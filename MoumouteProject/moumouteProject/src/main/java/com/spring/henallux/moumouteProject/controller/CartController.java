package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.model.CartItem;
import com.spring.henallux.moumouteProject.model.Constants;
import com.spring.henallux.moumouteProject.model.SearchWigForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CART})
public class CartController
{
    private final MessageSource messageSource;

    @Autowired
    public CartController(MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }

    @ModelAttribute(Constants.CART)
    public HashMap<Integer,CartItem> cart(){
        return new HashMap<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.CART)HashMap<Long, CartItem> cart, Locale locale)
    {
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("cartSize", cart.size());
        return "integrated:cart";
    }
}
