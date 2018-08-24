package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.dataAccess.dao.WigDAO;
import com.spring.henallux.moumouteProject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.Locale;

@Controller
@RequestMapping(value="/research")
@SessionAttributes({Constants.CART})
public class ResearchController {


    private WigDAO wigDAO;

    @Autowired
    public ResearchController(WigDAO wigDAO)
    {
        this.wigDAO   = wigDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getFormData(Model model, @ModelAttribute(value="itemToSearch")SearchWigForm form,Locale locale)
    {
        System.out.print(isCategoryNumber(form.getCategory()));
        if(form.getCategory() != null && (form.getCategory().equals("all") || isCategoryNumber(form.getCategory()))) {
            if(form.getWigName() == null) {
                form.setWigName("");
            }
            model.addAttribute("itemsList", wigDAO.getAllWigFromCategoryAndName(form.getCategory(), locale.getLanguage(), form.getWigName()));
            return "integrated:itemsList";
        } else {
            return "redirect:/home";
        }
    }

    private boolean isCategoryNumber(String category) {
        try {
            Integer.parseInt(category);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
