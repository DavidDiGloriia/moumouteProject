package com.spring.henallux.moumouteProject.controller;


import com.spring.henallux.moumouteProject.dataAccess.entity.UserEntity;
import com.spring.henallux.moumouteProject.model.SearchWigForm;
import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/login")
public class LoginController
{
    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model, @RequestParam(required = false)boolean isError)
    {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("errorMessage", isError);
        model.addAttribute("itemToSearch", new SearchWigForm());
        return "integrated:login";
    }
}
