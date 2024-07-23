package com.example.growith.en;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/en")
@Controller
public class EnController {
    @GetMapping("/index")
    public String index() {
        return "/en/index";
    }

    @GetMapping("/about/overview")
    public String overview() {
        return "/en/about_overview";
    }

    @GetMapping("/about/team")
    public String team() {
        return "/en/about_team";
    }

    @GetMapping("/about/history")
    public String history() {
        return "/en/about_history";
    }

    @GetMapping("/projects/current")
    public String current() {
        return "/en/projects_current";
    }

    @GetMapping("/projects/projects")
    public String projects() {
        return "/en/projects_projects";
    }
    @GetMapping("/projects/gallery")
    public String gallery() {
        return "/en/projects_gallery";
    }
    @GetMapping("/support/notice")
    public String notice() {
        return "/en/support_notice";
    }


}
