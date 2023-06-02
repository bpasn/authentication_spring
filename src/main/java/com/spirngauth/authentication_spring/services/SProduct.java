package com.spirngauth.authentication_spring.services;

import com.spirngauth.authentication_spring.interfaces.IProduct;
import com.spirngauth.authentication_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("sProduct")
public class SProduct implements IProduct {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<String> getAllProduct() {
        return null;
    }

    @Override
    public Optional<String> getProductByname(String name) {
        return Optional.empty();
    }
}
