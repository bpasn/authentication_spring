package com.spirngauth.authentication_spring.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirngauth.authentication_spring.models.ErrorResponse;
import com.spirngauth.authentication_spring.payload.request.categories.ReqCategory;
import com.spirngauth.authentication_spring.payload.response.ResPayload;
import com.spirngauth.authentication_spring.services.SCategories;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    private SCategories sCagetories;

    @GetMapping("get-all")
    public ResponseEntity<ResPayload> getAllCategories(){
        return ResponseEntity.ok(sCagetories.getCategories());
    }
    // , consumes = "multipart/form-data",produces = {"application/json"}
    @PostMapping(value = "create")
    public ResponseEntity<?> createCategories(@RequestBody ReqCategory req) throws FileNotFoundException, IOException, Exception{
        if(req.getImagePath() == null){
            return  ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,"Image Is Require"));
        }
        return ResponseEntity.ok(sCagetories.createCategories(req));
    }

}
