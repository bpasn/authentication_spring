package com.spirngauth.authentication_spring.controllers;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirngauth.authentication_spring.models.ECode;
import com.spirngauth.authentication_spring.models.ERole;
import com.spirngauth.authentication_spring.models.RoleModel;
import com.spirngauth.authentication_spring.models.UserModel;
import com.spirngauth.authentication_spring.payload.request.LoginRequest;
import com.spirngauth.authentication_spring.payload.request.SignupRequest;
import com.spirngauth.authentication_spring.payload.response.JwtResponse;
import com.spirngauth.authentication_spring.payload.response.MessageResponse;
import com.spirngauth.authentication_spring.provider.CustomAuthenticationProvider;
import com.spirngauth.authentication_spring.repository.RoleRepository;
import com.spirngauth.authentication_spring.repository.UserRepository;
import com.spirngauth.authentication_spring.security.jwt.JwtUtils;
import com.spirngauth.authentication_spring.security.services.UserDetailsImpl;

import jakarta.validation.Valid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
      
        Authentication authentication = customAuthenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(
                new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        try {

            if (userRepository.existsByUsername(signupRequest.getUsername())) {
                return ResponseEntity.badRequest()
                        .body(new MessageResponse("Error: Username is already taken!", HttpStatus.BAD_REQUEST,409));
            }

            if (userRepository.existsByEmail(signupRequest.getEmail())) {
                return ResponseEntity.badRequest()
                        .body(new MessageResponse("Error: Email is already in use!", HttpStatus.BAD_REQUEST,409));
            }

            // Create new User's account
            UserModel user = new UserModel(
                    signupRequest.getUsername(),
                    signupRequest.getEmail(),
                    signupRequest.getFirstName(),
                    signupRequest.getLastName(),
                    signupRequest.getTelephone(),
                    encoder.encode(signupRequest.getPassword()));

            List<String> strRoles = signupRequest.getRole();
            Set<RoleModel> roles = new HashSet<>();

            if (strRoles == null) {
                RoleModel userRole = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(userRole);
            } else {
                strRoles.forEach(role -> {
                    switch (role) {
                        case "admin":
                            RoleModel adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                            roles.add(adminRole);
                            break;
                        case "mod":
                            RoleModel modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                            roles.add(modRole);

                            break;

                        default:
                            RoleModel userRole = roleRepository.findByName(ERole.ROLE_USER)
                                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                            roles.add(userRole);
                    }
                });

            }
            user.setUserRole(roles);
            userRepository.save(user);
            return ResponseEntity.ok(new MessageResponse("User registerd successfully!", HttpStatus.CREATED, 200));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, 500));
        }

    }

}
