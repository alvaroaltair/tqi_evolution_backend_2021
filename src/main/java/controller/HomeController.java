package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/api/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/api/index")
    public String home() {
        return "index";
    }
}
