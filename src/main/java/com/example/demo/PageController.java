package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/addplayer")
    public String newPlayerPage() {
        return "addplayer"; // Thymeleaf will look for newplayer.html in templates
    }

    @GetMapping("/pairs")
    public String pairs() {
        return "pairs"; // Thymeleaf will look for newplayer.html in templates
    }
}
