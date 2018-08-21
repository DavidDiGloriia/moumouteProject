package com.spring.henallux.moumouteProject.service;

import com.spring.henallux.moumouteProject.dataAccess.dao.WigDAO;
import com.spring.henallux.moumouteProject.model.CartItem;
import com.spring.henallux.moumouteProject.model.CartItemDisplay;
import com.spring.henallux.moumouteProject.model.Wig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartService
{
    public static ArrayList<CartItemDisplay> getCartItemDisplayArray(HashMap<Integer, CartItem> cart, String lang, WigDAO wigDAO)
    {
        ArrayList<CartItemDisplay> cartItemDisplays = new ArrayList<>();
        Wig wig;
        for(Map.Entry<Integer, CartItem> entry : cart.entrySet())
        {
            wig = wigDAO.getWigById(entry.getValue().getItemId(), lang);

            cartItemDisplays.add(new CartItemDisplay(
                    entry.getValue().getItemId(),
                    wig.getWigName(),
                    wig.getPromotion() == null ? wig.getEVATPrice() * (1 + (wig.getVATRate()/100)) : (wig.getEVATPrice() * (1 + (wig.getVATRate()/100))) * (1 - (wig.getPromotion().getPercRed() / 100)),
                    entry.getValue().getQuantity(),
                    wig.getPictureLink()
            ));
        }
        return cartItemDisplays;
    }
}
