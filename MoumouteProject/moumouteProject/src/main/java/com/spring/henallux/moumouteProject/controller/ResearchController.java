package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.moumouteProject.dataAccess.dao.WigDAO;
import com.spring.henallux.moumouteProject.model.*;
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
@RequestMapping(value="/research")
@SessionAttributes({Constants.CART})
public class ResearchController {

    private final MessageSource messageSource;
    private WigDAO wigDAO;
    private CategoryDAO categoryDAO;

    @Autowired
    public ResearchController(MessageSource messageSource, WigDAO wigDAO, CategoryDAO categoryDAO)
    {
        this.messageSource = messageSource;
        this.wigDAO   = wigDAO;
        this.categoryDAO = categoryDAO;
    }

    @ModelAttribute(Constants.CART)
    public HashMap<Integer,CartItem> cart(){
        return new HashMap<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.CART)HashMap<Integer, CartItem> cart, Locale locale)
    {
        // TODO : Méthode à modifier / supprimer
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        model.addAttribute("cartSize", cart.size());
        model.addAttribute("categories", categoryDAO.getAllCategories());
        return "integrated:itemsList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getFormData(Model model, @ModelAttribute(value="itemToSearch")SearchWigForm form, @ModelAttribute(value = Constants.CART)HashMap<Integer,CartItem> cart, Locale locale)
    {
        model.addAttribute("categories", categoryDAO.getAllCategories());
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("title","Résultat de la recherche");
        model.addAttribute("itemsList", wigDAO.getAllWigFromCategory(Integer.parseInt(form.getCategory()), locale.getLanguage()));
        model.addAttribute("cartSize", cart.size());
        return "integrated:itemsList";
    }
}
