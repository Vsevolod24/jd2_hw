package it.academy.controller;

import it.academy.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class ContactController {
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact) {
        return "redirect:contact.html";  
    }  
      
    @RequestMapping("/contact")  
    public String showContacts(Model m) {
        m.addAttribute("command", new Contact());  
        return "contact";  
    }  
}  