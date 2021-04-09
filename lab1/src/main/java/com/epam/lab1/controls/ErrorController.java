package com.epam.lab1.controls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class ErrorController {
    private static final Logger log = LogManager.getLogger();
    @GetMapping("/{errorPage}")
    public String missingPage(@PathVariable(value = "errorPage") String page, Model model) {
        return "404";
    }
    @PostMapping("/{errorPage}")
    public String goToHome(@PathVariable(value = "errorPage") String page,Model model){
        return "main";
    }
}

