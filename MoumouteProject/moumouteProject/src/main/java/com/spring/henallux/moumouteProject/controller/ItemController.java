package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/items")
public class ItemController {

    @RequestMapping(value="/search", method = RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="searchItems")Wig wig)
    {
        return "integrated:home";
    }



}
