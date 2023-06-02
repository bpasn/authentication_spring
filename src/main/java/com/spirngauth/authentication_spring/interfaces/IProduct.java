package com.spirngauth.authentication_spring.interfaces;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface IProduct {
    List<String> getAllProduct();
    Optional<String> getProductByname(String name);



}
