package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.moumouteProject.dataAccess.dao.WigDAO;
import com.spring.henallux.moumouteProject.model.CartItem;
import com.spring.henallux.moumouteProject.model.Constants;
import com.spring.henallux.moumouteProject.model.SearchWigForm;
import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value="/items")
@SessionAttributes({Constants.CART})
public class ItemController {

    private WigDAO wigDAO;

    @Autowired
    ItemController(WigDAO wigDao)
    {
        this.wigDAO = wigDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @RequestParam(value="itemId")int idItem, Locale locale)
    {
        model.addAttribute("item",wigDAO.getWigFromId(idItem,locale.getLanguage()));
        model.addAttribute("itemToAdd", new CartItem());

        return "integrated:itemDetail";
    }


}
