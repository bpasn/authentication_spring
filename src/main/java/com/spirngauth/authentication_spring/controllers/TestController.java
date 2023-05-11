package com.spirngauth.authentication_spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirngauth.authentication_spring.payload.response.MessageResponse;
import com.spirngauth.authentication_spring.repository.IUserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    IUserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<?> allAccess() {
        return ResponseEntity.ok(new MessageResponse("Public Content"));
    }

   
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> userAccess() {
        return ResponseEntity.ok(new MessageResponse("User board"));
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public  ResponseEntity<?> moderatorAccess() {
        return ResponseEntity.ok(new MessageResponse("Moderator board"));
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<?> adminAccess() {
        return ResponseEntity.ok(new MessageResponse("Admin broad"));
    }

}
