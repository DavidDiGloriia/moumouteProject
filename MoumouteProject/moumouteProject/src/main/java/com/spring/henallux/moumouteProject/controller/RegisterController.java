package com.spring.henallux.moumouteProject.controller;


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
    private ProviderCenter providerCenter;
    private final MessageSource messageSource;

    @Autowired
    public RegisterController(UserDAO userDAO, ProviderCenter providerCenter, MessageSource messageSource)
    {
        this.userDAO = userDAO;
        this.providerCenter = providerCenter;
        this.messageSource = messageSource;
    }

    @ModelAttribute(Constants.CART)
    public HashMap<Integer,CartItem> cart(){
        return new HashMap<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model, @ModelAttribute(value = Constants.CART)HashMap<Long, CartItem> cart, Locale locale)
    {
        model.addAttribute("user", new UserRegisterForm());
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        model.addAttribute("cartSize", cart.size());
        return "integrated:register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getFormData(Model model, @Valid @ModelAttribute(value = "user")UserRegisterForm userRegisterForm, final BindingResult errors, @ModelAttribute(value = Constants.CART)HashMap<Long, CartItem> cart, Locale locale)
    {
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
                    model.addAttribute("itemToSearch", new SearchWigForm());
                    model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
                    model.addAttribute("cartSize", cart.size());
                    return "integrated:register";
                }

            }
        }
        else
        {
            model.addAttribute("itemToSearch", new SearchWigForm());
            model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
            model.addAttribute("cartSize", cart.size());
            return "integrated:register";
        }
    }
}
