package com.example.musikshop.HomeScreenController;

import com.example.musikshop.Service.MusikServiceIF;
import com.example.musikshop.Entity.Musik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
//@RequestMapping("/shopping")
public class HomeController {

    @Autowired
    MusikServiceIF musikServiceIF;

    @GetMapping("/hauptseite")
    public String starten(Model model){
        ArrayList<Musik> musik = new ArrayList<>();
        /*
        musik.add(new Musik("Amelie Lens",14.99,"Techno","Hexenmeister"));
        musik.add(new Musik("Klangkuenstler",14.99,"Techno","Balthazar"));
        musik.add(new Musik("Kobosil",14.99,"Techno","44"));

         */
        model.addAttribute("musikliste",musikServiceIF.getMusiklist());
        return"start";
    }

    @RequestMapping("/createmusik")
    public String createNewMusik(){
        return "createMusik";
    }

    @RequestMapping("/addMusic")
    public String insertMusik(@ModelAttribute("musikname")String musikname,
                              @ModelAttribute("price")double price,
                              @ModelAttribute("genre")String genre,
                              @ModelAttribute("artist") String artist,
                              Model model){

        Musik musik = new Musik(musikServiceIF.generateIndex(),musikname,price,genre,artist); //Todo
        musikServiceIF.createMusik(musik);
        return "redirekt:/";
    }
}
