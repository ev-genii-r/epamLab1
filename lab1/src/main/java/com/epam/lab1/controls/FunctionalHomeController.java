package com.epam.lab1.controls;
import com.epam.lab1.SQL.Post;
import com.epam.lab1.parametres.entityParametres;
import com.epam.lab1.repoSQL.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.lab1.myExceptions.dataInputException;
import validator.Validator;
import javax.swing.JOptionPane;
import java.io.IOException;

@Controller
public class FunctionalHomeController {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/funcHome")
    public String FuncHome(Model model){
        return "functionalHome";
    }
    @PostMapping("/funcHome")
    public String FunctionalCalculation(@RequestParam String inputLength,@RequestParam String inputSpeed, Model model)throws dataInputException {
        try{
            Validator validator=new Validator();
            validator.dataValidation(inputSpeed,inputLength);
            Parce parametres=(String str)->Double.parseDouble(str);
            Iterable<Post> posts = postRepository.findAll();
            model.addAttribute("time",parametres.getRes(inputLength,inputSpeed));
            Post post=new Post(inputSpeed,inputLength,parametres.getRes(inputLength,inputSpeed));
            postRepository.save(post);
            model.addAttribute("posts",posts);
        }catch (dataInputException ex){
            model.addAttribute("time", ex.getMessage());
            Post post=new Post();
            post.setGlobal(inputSpeed,inputLength,ex.getMessage());
            postRepository.save(post);
            log.error(ex.getMessage());
        }
        return "functionalHome";
    }
    interface Parce{
        default double getRes(String length, String speed){
            return parce(length)/parce(speed);
        }
        double parce(String str);
    }
}

