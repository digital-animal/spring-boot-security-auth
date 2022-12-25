package com.zahid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RestController 
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/user")
    public String user(Model model) {
        return "user";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }
}
