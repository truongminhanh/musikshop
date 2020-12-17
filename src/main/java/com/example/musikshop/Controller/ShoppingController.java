package com.example.musikshop.Controller;

import com.example.musikshop.Entity.CartItem;
import com.example.musikshop.Entity.Customer;
import com.example.musikshop.Entity.CustomerOrder;
import com.example.musikshop.Service.MusikServiceIF;
import com.example.musikshop.Service.auth.AccountAuthenticationService;
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

    ArrayList<CartItem> cart = new ArrayList<>();
    private int quantity = 1;
    private double total = 0;

    @Autowired
    private MusikServiceIF musikServiceIF;

    @Autowired
    private AccountAuthenticationService accountAuthenticationService;


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
            //cart.add(new CartItem(musikServiceIF.findMusik(id).get(),quantity)); 17.12
            CartItem cartItem = new CartItem(musikServiceIF.findMusik(id).get(),quantity);
            cart.add(cartItem);
            total = total +cartItem.getMusik().getPrice();
            model.addAttribute("musikcart",cart);
            model.addAttribute("total",String.valueOf(total));
            System.out.println(Arrays.toString(cart.toArray())+"test");
        }else{
            CartItem cartItem = findMusikInCart(id);
            total = total + cartItem.getMusik().getPrice();
            int newQuantity = cartItem.getQuantity() + 1;
            cartItem.setQuantity(newQuantity);
            model.addAttribute("musikcart",cart);
            model.addAttribute("total",String.valueOf(total));
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
        //cart.remove(findMusikInCart(id)); 17.12
        CartItem cartItem = findMusikInCart(id);
        cart.remove(cartItem);
        total = total - cartItem.getQuantity() * cartItem.getMusik().getPrice();
        model.addAttribute("cart",cart);
        model.addAttribute("total",String.valueOf(total));
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

    @RequestMapping("/payOrder")
    public String payOrder(){


        return "paymentSuccess";
    }
}
