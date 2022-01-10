package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/api/")
    public String inicio() {
        return "home";
    }

    @GetMapping("/api/home")
    public String home() {
        return "home";
    }
}
