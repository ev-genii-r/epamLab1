package com.epam.lab1.controls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.lab1.myExceptions.dataInputException;
import validator.Validator;
import java.io.IOException;

@Controller
public class FunctionalHomeController {
    private static final Logger log = LogManager.getLogger();
    @GetMapping("/funcHome")
    public String FuncHome(Model model){
        return "functionalHome";
    }
    @PostMapping("/funcHome")
    public String FunctionalCalculation(@RequestParam String inputLength,@RequestParam String inputSpeed, Model model)throws dataInputException {
        try{
            Validator validator=new Validator();
            validator.dataValidation(inputSpeed,inputLength);
            Transformation<String> transformString =str -> Double.parseDouble(str);
            validator.nullNegativeValidation(transformString.resultTransformation(inputSpeed),transformString.resultTransformation(inputLength));
            Calculation<Double> finalCalculations = (trans1,trans2) -> trans1/trans2;
            model.addAttribute("time",finalCalculations.resultCalculation(transformString.resultTransformation(inputLength),transformString.resultTransformation(inputSpeed)));
        }catch (dataInputException ex){
            model.addAttribute("time", ex.getMessage());
            log.error(ex.getMessage());
        }
        return "functionalHome";
    }
    interface Transformation<T>{
        double resultTransformation(T t);
    }
    interface Calculation<T>{
        double resultCalculation(T s, T l);
    }
}

