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
@RequestMapping(value = "/payment")
@SessionAttributes({Constants.CART})
public class PaymentController
{
    private final MessageSource messageSource;

    @Autowired
    public PaymentController(MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String payment(Model model, @ModelAttribute(value = Constants.CART)HashMap<Long, CartItem> cart, Locale locale)
    {
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("cartSize", cart.size());
        return "integrated:payment";
    }
}
