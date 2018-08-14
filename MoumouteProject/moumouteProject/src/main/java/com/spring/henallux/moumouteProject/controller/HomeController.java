package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.moumouteProject.model.Category;
import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.plugin2.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value={"", "/home"})
public class HomeController
{
    private final MessageSource messageSource;
    private CategoryDAO categoryDAO;
    @Autowired
    public HomeController(MessageSource messageSource, CategoryDAO categoryDAO)
    {
        this.categoryDAO = categoryDAO;
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale)
    {

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"test"));
        categoryList.add(new Category(1,"test2"));
        categoryList.add(new Category(1,"test3"));


        model.addAttribute("categories", categoryDAO.getAllCategories());
        model.addAttribute("itemToSearch", new Wig());
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        return "integrated:home";
    }


}
