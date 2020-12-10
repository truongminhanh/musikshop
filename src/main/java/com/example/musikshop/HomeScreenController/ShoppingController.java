package com.example.musikshop.HomeScreenController;

import com.example.musikshop.Entity.CartItem;
import com.example.musikshop.Service.MusikServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ShoppingController {

    List<CartItem> cart = new ArrayList<>();
    private int quantity = 1;
    @Autowired
    private MusikServiceIF musikServiceIF;




    @RequestMapping("/cart")
    public String cart(Model model){
        if(cart != null){
            model.addAttribute("musikcart",cart);
        }
        return "MusikCart";
    }


    @RequestMapping("/cart/buy/{id}")
    public String buyMusic(Model model, @PathVariable long id){
        //List<CartItem> cart = new ArrayList<>();
        //cart.add(new CartItem(musikServiceIF.findMusik(id).get()));
        //model.addAttribute("cart",cart);

        if(!check(id,cart)){
            cart.add(new CartItem(musikServiceIF.findMusik(id).get(),quantity));
            model.addAttribute("musikcart",cart);
            System.out.println(Arrays.toString(cart.toArray())+"test");
        }else{
            CartItem cartItem = findMusikInCart(id);
            int newQuantity = cartItem.getQuantity() + 1;
            cartItem.setQuantity(newQuantity);
            model.addAttribute("musikcart",cart);
        }

        return "MusikCart";
    }

    private boolean check(long id,List<CartItem> cart){
        for(int x =0;x<cart.size();x++){
            if (cart.get(x).getMusik().getMusikId() == id){
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/insertQuantity")
    public void addQuantity(@ModelAttribute("quantity") int quantity){
        this.quantity = quantity;
    }

    @RequestMapping("/remove/{id}")
    public String removeMusik(@PathVariable long id,Model model){
        cart.remove(findMusikInCart(id));
        model.addAttribute("cart",cart);
        return "MusikCart";
    }

    public CartItem findMusikInCart(long id){
        CartItem cartItem;
        for(int i= 0; i<cart.size();i++){
            if(cart.get(i).getCartMusikId() == id){
                cartItem = cart.get(i);
                return cartItem;
            }
        }
        return null;
    }
}
