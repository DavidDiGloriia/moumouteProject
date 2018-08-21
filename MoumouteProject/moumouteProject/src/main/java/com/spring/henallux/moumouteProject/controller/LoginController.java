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
public class LoginController
{
    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model, @RequestParam(required = false)boolean isError)
    {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("errorMessage", isError);


        return "integrated:login";
    }
}
