package com.example.musikshop.HomeScreenController;

import com.example.musikshop.Entity.CartItem;
import com.example.musikshop.Service.MusikServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingController {

    @Autowired
    private MusikServiceIF musikServiceIF;

    @RequestMapping("/cart/buy/{id}")
    public String buyMusic(Model model, @PathVariable long id){
        List<CartItem> cart = new ArrayList<>();
        cart.add(new CartItem(musikServiceIF.findMusik(id)));
        //model.addAttribute("cart",cart);
        return "MusikCart";
    }
}
