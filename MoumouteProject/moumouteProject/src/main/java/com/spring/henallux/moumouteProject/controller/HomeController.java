package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.moumouteProject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value={"", "/home"})
@SessionAttributes({Constants.CART})
public class HomeController
{
    private final MessageSource messageSource;
    private CategoryDAO categoryDAO;

    @Autowired
    public HomeController(MessageSource messageSource, CategoryDAO categoryDAO)
    {
        this.categoryDAO = categoryDAO;
        this.messageSource = messageSource;
    }

    @ModelAttribute(Constants.CART)
    public HashMap<Integer,CartItem> cart(){
        return new HashMap<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.CART)HashMap<Integer, CartItem> cart, Locale locale)
    {
        model.addAttribute("categories", categoryDAO.getAllCategories());
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        model.addAttribute("cartSize", cart.size());
        return "integrated:home";
    }


}
