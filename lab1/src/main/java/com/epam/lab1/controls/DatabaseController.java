package com.epam.lab1.controls;
import com.epam.lab1.fileWorker.FileWorker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DatabaseController {
    @GetMapping("/database")
    public String main(Model model) {
        return "database";
    }
    @PostMapping("/showDatabase")
    public String showDatabase(Model model)
    {
        FileWorker read=new FileWorker();
        model.addAttribute("database",read.read());
        return "database";
    }
    @PostMapping("/backDatabase")
    public String backDatabase(Model model)
    {
        return "main";
    }
}