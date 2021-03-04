package it.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/main")
    public String mainMethod(Model model) {
        String message = "Main";
        model.addAttribute("message", message);
        return "main";
    }  
}  