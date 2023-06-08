package com.spirngauth.authentication_spring.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spirngauth.authentication_spring.interfaces.ICategories;
import com.spirngauth.authentication_spring.models.Categories;
import com.spirngauth.authentication_spring.payload.request.categories.ReqCategory;
import com.spirngauth.authentication_spring.payload.response.BaseResponse;
import com.spirngauth.authentication_spring.payload.response.ResPayload;
import com.spirngauth.authentication_spring.repository.CategoriesRepo;

@Service
public class SCategories implements ICategories {
    @Autowired
    private CategoriesRepo categoriesRepo;

    @Autowired
    private CreateImagesService createImagesService;

    private static String msg = "Create Category Successfully !";

    @Override
    public ResPayload getCategories() {
        ResPayload response = new ResPayload();
        response.setSuccess(true);
        response.setPayload(categoriesRepo.findAll());
        return response;
    }

    @Override
    public BaseResponse createCategories(ReqCategory req) throws FileNotFoundException, IOException, Exception{
        String pathFile = createImagesService.createImage(req.getImagePath());
        Categories categories = new Categories();
        categories.setActive(true);
        categories.setCategoryDescription(req.getCategoryDescription());
        categories.setCategoryName(req.getCategoryName());
        categories.setImagePath(pathFile);
        categoriesRepo.save(categories);
        return response(true);
    }

    @Override
    public BaseResponse response(Boolean flag) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(flag);
        if (flag) {
            response.setMessage("Create Categories Successfully !");
        } else {
            response.setMessage("Create Categories Failed !");
        }
        return response;
    }

    @Override
    public BaseResponse response(Boolean flag, String msg) {
        BaseResponse response = new BaseResponse();
        response.setMessage(msg);
        response.setSuccess(flag);
        return response;
    }

}
