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


    private WigDAO wigDAO;

    @Autowired
    public ResearchController( WigDAO wigDAO)
    {
        this.wigDAO   = wigDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getFormData(Model model, @ModelAttribute(value="itemToSearch")SearchWigForm form,Locale locale)
    {
        model.addAttribute("itemsList", wigDAO.getAllWigFromCategoryAndName(form.getCategory(), locale.getLanguage(), form.getWigName()));
        return "integrated:itemsList";
    }
}
