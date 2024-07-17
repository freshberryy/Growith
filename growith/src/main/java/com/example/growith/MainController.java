package com.example.growith;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin_login";
    }

    @PostMapping("/admin")
    public String adminPost() {
        return "redirect:/";
    }
}
