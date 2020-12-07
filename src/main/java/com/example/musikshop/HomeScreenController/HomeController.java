package com.example.musikshop.HomeScreenController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopping")
public class HomeController {

    @GetMapping("/hauptseite")
    public String starten(){
        return"start";
    }
}
