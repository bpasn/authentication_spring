package com.spirngauth.authentication_spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirngauth.authentication_spring.payload.response.ResPayload;
import com.spirngauth.authentication_spring.services.SLoadingPage;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class InitialController {
    @Autowired
    private SLoadingPage sLoadingPage;


    @GetMapping("load-menu")
    public ResponseEntity<ResPayload> loadMenu(){
        return ResponseEntity.ok(sLoadingPage.getMenuItem());

    }
}
