package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.model.SearchWigForm;
import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Locale;

@Controller
@RequestMapping(value="/research")
public class ResearchController {

    private final MessageSource messageSource;

    @Autowired
    public ResearchController(MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale)
    {
        model.addAttribute("itemToSearch", new Wig());
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        return "integrated:itemsList";
    }

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String getFormData(Model model, @ModelAttribute(value="itemToSearch")SearchWigForm form)
    {

        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("title","Résultat de la recherche pour "+form.getWigName());
        return "integrated:itemsList";
    }







}
