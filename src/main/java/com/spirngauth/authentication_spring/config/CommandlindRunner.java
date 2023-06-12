package com.spirngauth.authentication_spring.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spirngauth.authentication_spring.models.AttributeValues;
import com.spirngauth.authentication_spring.models.Attributes;
import com.spirngauth.authentication_spring.models.ERole;
import com.spirngauth.authentication_spring.models.ListMenu;
import com.spirngauth.authentication_spring.models.Menus;
import com.spirngauth.authentication_spring.models.RoleModel;
import com.spirngauth.authentication_spring.models.SubMenus;
import com.spirngauth.authentication_spring.repository.AttributeRepo;
import com.spirngauth.authentication_spring.repository.AttributeValueRepo;
import com.spirngauth.authentication_spring.repository.ListMenuRepo;
import com.spirngauth.authentication_spring.repository.MenuRepo;
import com.spirngauth.authentication_spring.repository.RoleRepository;

import lombok.val;

@Configuration
public class CommandlindRunner implements CommandLineRunner {
    private final String JSONFILE = "/data.json";
    private final String JSONFILEMENU = "/dataMenu.json";

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeValueRepo attributeValueRepo;

    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    private ListMenuRepo listMenuRepo;

    @Autowired
    private RoleRepository roleRepository;
    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        if (attributeRepo.findAll().isEmpty() &&
                attributeValueRepo.findAll().isEmpty()) {
            TypeReference<HashMap<String, List<String>>> typeReference = new TypeReference<HashMap<String, List<String>>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream(JSONFILE);
            HashMap<String, List<String>> json = new ObjectMapper().readValue(inputStream, typeReference);
            json.forEach((key, value) -> {
                Attributes atts = new Attributes();
                atts.setAttributeName(key);
                attributeRepo.save(atts);
                value.forEach((String val) -> {
                    AttributeValues attrv = new AttributeValues();
                    attrv.setAttributeValue(val);
                    attrv.setAttributeId(atts);
                    attributeValueRepo.save(attrv);

                });
            });
        }
        if (menuRepo.findAll().isEmpty() && listMenuRepo.findAll().isEmpty()) {
            TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream(JSONFILEMENU);
            List<HashMap<String, Object>> json = new ObjectMapper().readValue(inputStream,
                    typeReference);

            json.forEach(item -> {
                Menus menu = new Menus();
                menu.setHeadName(item.get("headerName").toString());
                menu.setUrl(item.get("headerUrl").toString());
                Set<ListMenu> sListMenu = new HashSet<>();
                List<HashMap<String, Object>> submenu = (List) item.get("subMenus");
                submenu.forEach(sub -> {

                    List<String> roles = (List) sub.get("roles");
                    Set<RoleModel> sRole = new HashSet<>();
                    ListMenu glistMenu = new ListMenu();
                    roles.forEach(_role -> {
                        RoleModel roleModel = roleRepository.findByName(ERole.valueOf(_role))
                                .orElseThrow(() -> new RuntimeException("ROLE NOT FOUND"));
                        sRole.add(roleModel);
                    });

                    glistMenu.setMenuName(sub.get("name").toString());
                    glistMenu.setMenuUrl(sub.get("url").toString());
                    glistMenu.setRoles(sRole);
                    sListMenu.add(glistMenu);
                    listMenuRepo.save(glistMenu);
                });
                menu.setListMenus(sListMenu);
                menuRepo.save(menu);

            });

        }
    }

}
