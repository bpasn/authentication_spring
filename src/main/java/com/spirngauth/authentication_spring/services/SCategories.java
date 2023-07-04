package com.spirngauth.authentication_spring.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.spirngauth.authentication_spring.utils.CreateImagesService;

import io.swagger.models.Path;

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
    public ResPayload getCategories(int page, int pageSize) {
        ResPayload response = new ResPayload();
        PageRequest paging = PageRequest.of(page,pageSize);
        Page<Categories> pageResult = categoriesRepo.findAll(page > 1 ? paging.withPage(page) : paging);
        HashMap<String,Object> map = new HashMap<>();

        map.put("data",pageResult.get());
        map.put("count",categoriesRepo.count());
        response.setSuccess(true);
        response.setPayload(map);
        return response;
    }

    @Override
    public BaseResponse createCategories(ReqCategory req) throws FileNotFoundException, IOException, Exception {
        if (categoriesRepo.findByCategoryName(req.getCategoryName()).isEmpty()) {
            String pathFile = createImagesService.createImage(req.getImagePath());
            Categories categories = new Categories();
            categories.setActive(req.getActive());
            categories.setCategoryDescription(req.getCategoryDescription());
            categories.setCategoryName(req.getCategoryName());
            categories.setImagePath(pathFile.toString());
            categoriesRepo.save(categories);
            return response(true);
        }
        return response(false, String.format("Category Name : %s is Already exists", req.getCategoryName()));
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
