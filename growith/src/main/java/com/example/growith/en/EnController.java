package com.example.growith.en;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/en")
@Controller
public class EnController {
    @GetMapping("/index")
    public String details() {
        return "en/index";
    }


}
