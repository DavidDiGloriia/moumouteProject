package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.moumouteProject.dataAccess.dao.WigDAO;
import com.spring.henallux.moumouteProject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CART})
public class CartController
{
    private final MessageSource messageSource;
    private CategoryDAO categoryDAO;
    private WigDAO wigDAO;

    @Autowired
    public CartController(MessageSource messageSource, WigDAO wigDAO, CategoryDAO categoryDAO)
    {
        this.messageSource = messageSource;
        this.wigDAO = wigDAO;
        this.categoryDAO = categoryDAO;
    }

    @ModelAttribute(Constants.CART)
    public HashMap<Integer,CartItem> cart(){
        return new HashMap<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.CART)HashMap<Integer, CartItem> cart, Locale locale)
    {
        ArrayList<CartItemDisplay> cartItemDisplays =  getCartItemDisplayArray(cart,locale.getLanguage());

        model.addAttribute("cartItems", cartItemDisplays);
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("cartSize", cart.size());
        model.addAttribute("categories", categoryDAO.getAllCategories());
        return "integrated:cart";
    }

    @RequestMapping(method = RequestMethod.GET, value="/deleteItemFromCart")
    public String deleteItemFromCart(@RequestParam(value="itemId")int idItem, @ModelAttribute(value = Constants.CART)HashMap<Integer, CartItem> cart)
    {
        cart.remove(idItem);
        return "redirect:/cart";
    }


    private ArrayList<CartItemDisplay> getCartItemDisplayArray(HashMap<Integer, CartItem> cart, String lang)
    {
        ArrayList<CartItemDisplay> cartItemDisplays = new ArrayList<>();
        Wig wig;
        for(Map.Entry<Integer, CartItem> entry : cart.entrySet())
        {
            wig = wigDAO.getWigById(entry.getValue().getItemId(), lang);

           cartItemDisplays.add(new CartItemDisplay(
                   entry.getValue().getItemId(),
                   wig.getWigName(),
                   wig.getEVATPrice() * (1 + (wig.getVATRate()/100)),
                   entry.getValue().getQuantity(),
                   wig.getPictureLink()
           ));
        }
        return cartItemDisplays;
    }


}
