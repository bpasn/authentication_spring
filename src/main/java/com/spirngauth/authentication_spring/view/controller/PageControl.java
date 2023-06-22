package com.spirngauth.authentication_spring.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spirngauth.authentication_spring.models.Categories;
import com.spirngauth.authentication_spring.repository.CategoriesRepo;

import org.springframework.ui.Model;
@Controller
@RequestMapping(value="/webportal")
public class PageControl {
    @Autowired
    CategoriesRepo repo;

    
    @GetMapping("")
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        model.addAttribute("page","home");
        model.addAttribute("name", name);
        return "page/page-content";
    }

    @GetMapping("categories")

    public String categories(Model model){

        model.addAttribute("page","categories");
        return "page/categories";
    }
}
