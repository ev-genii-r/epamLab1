package com.epam.lab1.controls;
//package src.main.resources.templates;

import com.sun.el.lang.FunctionMapperImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epam.lab1.parametres.entityParametres;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/home")
    public String main(Model model) {
        entityParametres parametres=new entityParametres();
        model.addAttribute("speed");
        model.addAttribute("length");
        model.addAttribute("time",parametres.getSpeed());
        return "home";
    }
    @PostMapping("/home")
    public String mainProcessing(@RequestParam int speed,@RequestParam int length, Model model){
        entityParametres parametres=new entityParametres(speed,length);
        model.addAttribute("time",parametres.getSpeed());
        return "home";
    }
}