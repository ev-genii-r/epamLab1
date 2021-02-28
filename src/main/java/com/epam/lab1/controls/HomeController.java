package com.epam.lab1.controls;
//package src.main.resources.templates;

import com.sun.el.lang.FunctionMapperImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.epam.lab1.parametres.entityParametres;
import validator.Validator;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String main(Model model) {
        entityParametres parametres=new entityParametres();
        model.addAttribute("speed");
        model.addAttribute("length");
        model.addAttribute("time","input length and speed to get time");
        return "home";
    }
    @PostMapping("/home")
    public String mainProcessing(@RequestParam String inputSpeed,@RequestParam String inputLength, Model model) throws Exception{
        Validator validator=new Validator();
        if(validator.dataValidation(inputSpeed,inputLength)) {
            double speed=Double.parseDouble(inputSpeed);
            double length=Double.parseDouble(inputLength);
            validator.nullNegativeValidation(speed,length);
            entityParametres parametres = new entityParametres(speed, length);
            if (validator.getException() == "no exception") {
                model.addAttribute("time", "время=" + parametres.getSpeed() + " часов");
            } else {
                model.addAttribute("time", validator.getException());
            }
        }else{
            model.addAttribute("time","Please input correct data");
        }
        return "home";
    }
    @PostMapping("/goHome")
    public String returnToMain(Model model){
        return "main";
    }
}