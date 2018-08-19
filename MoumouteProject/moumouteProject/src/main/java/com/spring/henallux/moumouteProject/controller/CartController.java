package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.dataAccess.dao.WigDAO;
import com.spring.henallux.moumouteProject.model.CartItem;
import com.spring.henallux.moumouteProject.model.Constants;
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
    private WigDAO wigDAO;

    @Autowired
    public CartController(MessageSource messageSource, WigDAO wigDAO)
    {
        this.messageSource = messageSource;
        this.wigDAO = wigDAO;
    }

    @ModelAttribute(Constants.CART)
    public HashMap<Integer,CartItem> cart(){
        return new HashMap<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.CART)HashMap<Long, CartItem> cart, Locale locale)
    {
        cart = translateCart(cart, locale.getLanguage());

        ArrayList<CartItem> displayCart = new ArrayList<CartItem>(cart.values());
        double totalPrice = 0;
        for(CartItem item : displayCart)
        {
            totalPrice += item.getItemPrice() * item.getQuantity();
        }

        model.addAttribute("cartItems", displayCart);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("cartSize", cart.size());
        return "integrated:cart";
    }

    private HashMap<Long, CartItem> translateCart(HashMap<Long, CartItem> cart, String lang)
    {
        // Supprimer d'ici
            cart.put(new Long(1), new CartItem(1));
            cart.put(new Long(2), new CartItem(2, 4));
            cart.put(new Long(3), new CartItem(3, 2));
            cart.put(new Long(4), new CartItem(4));
        // A Là

        HashMap<Long, CartItem> translatedCart = new HashMap<>();
        CartItem tempCartItem;
        Wig tempWig;
        for(Map.Entry<Long, CartItem> entry : cart.entrySet())
        {
            tempCartItem = new CartItem(entry.getValue().getItemId(), entry.getValue().getQuantity());
            tempWig = wigDAO.getWigById(entry.getValue().getItemId(), lang);
            tempCartItem.setItemName(tempWig.getWigName());
            tempCartItem.setItemPrice(tempWig.getEVATPrice() * (1 + (tempWig.getVATRate()/100)));
            translatedCart.put(entry.getKey(), tempCartItem);
        }
        return translatedCart;
    }
}
