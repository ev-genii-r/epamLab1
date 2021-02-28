package com.epam.lab1.controls;
//package src.main.resources.templates;

import com.sun.el.lang.FunctionMapperImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.epam.lab1.parametres.entityParametres;
import validator.Validator;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }
    @PostMapping("/")
    public String goToHome(Model model){
        return "home";
    }
}
