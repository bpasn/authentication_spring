package com.spirngauth.authentication_spring.controllers;

import org.aspectj.weaver.loadtime.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirngauth.authentication_spring.payload.response.MessageResponse;
import com.spirngauth.authentication_spring.repository.UserRepository;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<?> allAccess() {
        return ResponseEntity.ok(new MessageResponse("Public Content"));
    }


    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> userAccess() {
        try {
            return ResponseEntity.ok(new MessageResponse("Public Content"));

        } catch (SignatureException e) {
            return ResponseEntity.ok("Invalid JWT signature: {}" + new MessageResponse(e.getMessage()));
        } catch (MalformedJwtException e) {
            return ResponseEntity.ok("Invalid JWT token: {}" + new MessageResponse(e.getMessage()));
        } catch (ExpiredJwtException e) {
            return ResponseEntity.ok("JWT token is expired: {}" + new MessageResponse(e.getMessage()));
        } catch (UnsupportedJwtException e) {
            return ResponseEntity.ok("JWT token is unsupported: {}" + new MessageResponse(e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok("JWT claims string is empty: {}" + new MessageResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok("EXCEPT :" + new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('NODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board";
    }

}
