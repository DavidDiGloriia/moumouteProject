package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.dataAccess.dao.WigDAO;
import com.spring.henallux.moumouteProject.model.*;
import com.spring.henallux.moumouteProject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CART})
public class CartController
{
    private WigDAO wigDAO;
    private CartService cartService;

    @Autowired
    public CartController(WigDAO wigDAO, CartService cartService)
    {
        this.wigDAO = wigDAO;
        this.cartService = cartService;
    }

    @ModelAttribute(Constants.CART)
    public HashMap<Integer,CartItem> cart(){
        return new HashMap<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.CART)HashMap<Integer, CartItem> cart, Locale locale)
    {
        ArrayList<CartItemDisplay> cartItemDisplays = cartService.getCartItemDisplayArray(cart,locale.getLanguage(), wigDAO);
        model.addAttribute("cartItems", cartItemDisplays);
        model.addAttribute("totalPrice", cartService.getTotalPrice(cartItemDisplays));
        model.addAttribute("totalQuantity", cartService.getTotalQuantity(cartItemDisplays));
        return "integrated:cart";
    }

    @RequestMapping(method = RequestMethod.GET, value="/deleteItemFromCart")
    public String deleteItemFromCart(@RequestParam(value="itemId")int idItem, @ModelAttribute(value = Constants.CART)HashMap<Integer, CartItem> cart)
    {
        cart.remove(idItem);
        return "redirect:/cart";
    }

    @RequestMapping(method = RequestMethod.POST, value="/addItemToCart")
    public String addItemToCart(@ModelAttribute(value="itemToAdd")CartItem itemToAdd, @ModelAttribute(value = Constants.CART)HashMap<Integer, CartItem> cart)
    {
        cart.put(itemToAdd.getItemId(), itemToAdd);
        return "redirect:/home";
    }
}
