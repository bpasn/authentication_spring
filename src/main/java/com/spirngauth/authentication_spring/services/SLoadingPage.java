package com.spirngauth.authentication_spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spirngauth.authentication_spring.interfaces.ILoadingPage;
import com.spirngauth.authentication_spring.models.Menus;
import com.spirngauth.authentication_spring.payload.response.ResPayload;
import com.spirngauth.authentication_spring.repository.ListMenuRepo;
import com.spirngauth.authentication_spring.repository.MenuRepo;

@Service
public class SLoadingPage implements ILoadingPage{
    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    private ListMenuRepo listMenuRepo;

    @Override
    public ResPayload getMenuItem() {
        ResPayload resPayload = new ResPayload();
        List<Menus> menus = menuRepo.findAll();
        resPayload.setSuccess(true);
        resPayload.setPayload(menus);
        return resPayload;
    }


    
    
    
}
