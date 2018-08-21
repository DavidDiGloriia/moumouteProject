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
    @RequestMapping(method = RequestMethod.GET)
    public String home()
    {
        return "integrated:home";
    }


}
