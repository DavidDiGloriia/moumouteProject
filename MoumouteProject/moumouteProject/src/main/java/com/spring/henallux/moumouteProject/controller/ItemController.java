package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.dataAccess.dao.WigDAO;
import com.spring.henallux.moumouteProject.model.CartItem;
import com.spring.henallux.moumouteProject.model.Constants;
import com.spring.henallux.moumouteProject.model.SearchWigForm;
import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value="/items")
public class ItemController {

    private WigDAO wigDAO;

    @Autowired
    ItemController(WigDAO wigDao)
    {
        this.wigDAO = wigDao;
    }

    @ModelAttribute(Constants.CART)
    public HashMap<Integer,CartItem> cart(){
        return new HashMap<>();
    }


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.CART)HashMap<Long, CartItem> cart, @RequestParam(value="itemId")int idItem, Locale locale)
    {
        System.out.println("VAL" + idItem);
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("title","");
        model.addAttribute("cartSize", cart.size());
        model.addAttribute("item",wigDAO.getWigFromId(idItem,"FR"));
        return "integrated:itemDetail";
    }



}
