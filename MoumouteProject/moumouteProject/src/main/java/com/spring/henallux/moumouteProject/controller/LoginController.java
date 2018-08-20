package com.spring.henallux.moumouteProject.controller;


import com.spring.henallux.moumouteProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.moumouteProject.dataAccess.entity.UserEntity;
import com.spring.henallux.moumouteProject.model.CartItem;
import com.spring.henallux.moumouteProject.model.Constants;
import com.spring.henallux.moumouteProject.model.SearchWigForm;
import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes({Constants.CART})
public class LoginController
{
    private final MessageSource messageSource;
    private CategoryDAO categoryDAO;

    @Autowired
    public LoginController(MessageSource messageSource, CategoryDAO categoryDAO)
    {
        this.messageSource = messageSource;
        this.categoryDAO = categoryDAO;
    }

    @ModelAttribute(Constants.CART)
    public HashMap<Integer,CartItem> cart(){
        return new HashMap<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model, @RequestParam(required = false)boolean isError, @ModelAttribute(value = Constants.CART)HashMap<Integer, CartItem> cart, Locale locale)
    {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("errorMessage", isError);
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        model.addAttribute("cartSize", cart.size());
        model.addAttribute("categories", categoryDAO.getAllCategories());
        return "integrated:login";
    }
}
