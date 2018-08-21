package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.model.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/about")
@SessionAttributes({Constants.CART})
public class AboutController
{
    @RequestMapping(method = RequestMethod.GET)
    public String about()
    {
        return "integrated:about";
    }
}
