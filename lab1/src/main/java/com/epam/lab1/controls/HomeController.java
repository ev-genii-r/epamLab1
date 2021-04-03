package com.epam.lab1.controls;
import com.epam.lab1.collection.CollectionWorker;
import com.epam.lab1.fileWorker.FileWorker;
import com.epam.lab1.myExceptions.dataInputException;
import com.epam.lab1.sort.Comparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.epam.lab1.parametres.entityParametres;
import validator.Validator;

import java.io.IOException;

@Controller
public class HomeController {
    FileWorker toFile=new FileWorker();
    CollectionWorker collection = new CollectionWorker();
    private static final Logger log = LogManager.getLogger();
    @GetMapping("/home")
    public String main(Model model) {
        entityParametres parametres=new entityParametres();
        model.addAttribute("speed");
        model.addAttribute("length");
        model.addAttribute("time","input length and speed to get time");
        return "home";
    }

    @PostMapping("/home")
    public String mainProcessing(@RequestParam String inputSpeed,@RequestParam String inputLength, Model model) throws IOException {
        Validator validator=new Validator();
        try {
            validator.dataValidation(inputSpeed, inputLength);
            double speed=Double.parseDouble(inputSpeed);
            double length=Double.parseDouble(inputLength);
            validator.nullNegativeValidation(speed,length);
            entityParametres parametres = new entityParametres(speed, length);
            model.addAttribute("time", "время=" + parametres.getSpeed() + " часов");
            collection.setElement(parametres);
            Comparator comparator=new Comparator();
            CollectionWorker sortedCollection=new CollectionWorker();
            sortedCollection.list=comparator.sortCollection(collection.list);
            toFile.write(sortedCollection.list);
        }catch (dataInputException ex){
            model.addAttribute("time", ex.getMessage());
            entityParametres parametres=new entityParametres(inputLength,inputSpeed,ex.getMessage());
            log.error(ex.getMessage());
        }
        return "home";
    }

    @PostMapping("/goHome")
    public String returnToMain(Model model){
        return "main";
    }
}