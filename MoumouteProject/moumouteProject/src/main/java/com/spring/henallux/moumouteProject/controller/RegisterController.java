package com.spring.henallux.moumouteProject.controller;


import com.spring.henallux.moumouteProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.moumouteProject.dataAccess.dao.UserDAO;
import com.spring.henallux.moumouteProject.dataAccess.util.ProviderCenter;
import com.spring.henallux.moumouteProject.model.CartItem;
import com.spring.henallux.moumouteProject.model.Constants;
import com.spring.henallux.moumouteProject.model.SearchWigForm;
import com.spring.henallux.moumouteProject.model.UserRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/register")
@SessionAttributes({Constants.CART})
public class RegisterController
{
    private UserDAO userDAO;
    private CategoryDAO categoryDAO;
    private final MessageSource messageSource;

    @Autowired
    public RegisterController(UserDAO userDAO, MessageSource messageSource, CategoryDAO categoryDAO)
    {
        this.userDAO = userDAO;
        this.messageSource = messageSource;
        this.categoryDAO = categoryDAO;
    }

    @ModelAttribute(Constants.CART)
    public HashMap<Integer,CartItem> cart(){
        return new HashMap<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model, @ModelAttribute(value = Constants.CART)HashMap<Integer, CartItem> cart, Locale locale)
    {
        model.addAttribute("user", new UserRegisterForm());
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        model.addAttribute("cartSize", cart.size());
        model.addAttribute("categories", categoryDAO.getAllCategories());
        return "integrated:register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getFormData(Model model, @Valid @ModelAttribute(value = "user")UserRegisterForm userRegisterForm, final BindingResult errors, @ModelAttribute(value = Constants.CART)HashMap<Integer, CartItem> cart, Locale locale)
    {
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        model.addAttribute("cartSize", cart.size());
        model.addAttribute("categories", categoryDAO.getAllCategories());

        if(!errors.hasErrors())
        {
            boolean otherError = false;

            if(userDAO.isUsernameUsed(userRegisterForm.getUsername())) {
                otherError = true;
                model.addAttribute("wrongUsername", true);
            } else {
                model.addAttribute("wrongUsername", false);
            }

            if(userDAO.isEmailUser(userRegisterForm.getEmail())) {
                otherError = true;
                model.addAttribute("wrongEmail", true);
            } else {
                model.addAttribute("wrongEmail", false);
            }

            if(!userRegisterForm.getPassword().equals(userRegisterForm.getConfirmPassword())) {
                otherError = true;
                model.addAttribute("wrongPassword", true);
            } else {
                model.addAttribute("wrongPassword", false);
            }

            if(otherError)
            {
                return "integrated:register";
            }
            else
            {
                if(userDAO.registerUser(userRegisterForm)) {
                    return "redirect:/login";
                } else {
                    model.addAttribute("errorOccurred", true);
                    return "integrated:register";
                }
            }
        }
        else
        {
            return "integrated:register";
        }
    }
}
