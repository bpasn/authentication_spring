package com.spirngauth.authentication_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("test")
    public String index(){
        return "page/page-content";
    }
}
