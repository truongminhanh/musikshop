package com.example.musikshop.HomeScreenController;

import com.example.musikshop.Entity.Address;
import com.example.musikshop.Entity.Customer;
import com.example.musikshop.Service.CustomerServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
    @Autowired
    private CustomerServiceIF customerServiceIF; //todo

    @RequestMapping("/registration")
    public String SignUp(Model model){
        return "registrationPage";
    }

    @RequestMapping("/registerUser")
    public String signUpCustomer (@ModelAttribute("firstName")String firstName,
                                  @ModelAttribute("lastname")String lastName,
                                  @ModelAttribute("email")String email,
                                  @ModelAttribute("passwordReg") String password,
                                  @ModelAttribute("streetName")String streetName,
                                  @ModelAttribute("zipCode") Integer zipCode,
                                  @ModelAttribute("city")String city){
        Customer newCustomer = new Customer(email,firstName,lastName,password,
                new Address(streetName,zipCode,city));
        customerServiceIF.registerNewUser(newCustomer);
        return "redirect:/hauptseite";
    }
}
