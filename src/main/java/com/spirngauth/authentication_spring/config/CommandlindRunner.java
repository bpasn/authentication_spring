// package com.spirngauth.authentication_spring.config;

// import java.io.InputStream;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Configuration;

// import com.fasterxml.jackson.core.type.TypeReference;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.spirngauth.authentication_spring.models.AttributeValues;
// import com.spirngauth.authentication_spring.models.Attributes;
// import com.spirngauth.authentication_spring.repository.AttributeRepo;
// import com.spirngauth.authentication_spring.repository.AttributeValueRepo;

// import lombok.val;

// @Configuration
// public class CommandlindRunner implements CommandLineRunner {
//     private final String JSONFILE = "/data.json";

//     @Autowired
//     private AttributeRepo attributeRepo;

//     @Autowired
//     private AttributeValueRepo attributeValueRepo;

//     private static final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

//     @Override
//     public void run(String... args) throws Exception {
//         TypeReference<HashMap<String, List<String>>> typeReference = new TypeReference<HashMap<String, List<String>>>() {
//         };

//         InputStream inputStream = TypeReference.class.getResourceAsStream(JSONFILE);

//         HashMap<String, List<String>> json = new ObjectMapper().readValue(inputStream, typeReference);
//         json.forEach((key, value) -> {
//             Attributes atts = new Attributes();
//             atts.setAttributeName(key);
//             attributeRepo.save(atts);
//             value.forEach((String val) -> {
//                 AttributeValues attrv = new AttributeValues();
//                 attrv.setAttributeValue(val);
//                 attrv.setAttributeId(atts);
//                 attributeValueRepo.save(attrv);

//             });
//         });
//     }

// }
