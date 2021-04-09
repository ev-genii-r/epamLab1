package com.epam.lab1.controls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/database")
    public String database(Model model){
        return "database";
    }
    @PostMapping("/FuncHome")
    public  String functionatController(Model model){
        return "functionalHome";
    }
}
