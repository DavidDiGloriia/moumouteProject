package com.spring.henallux.moumouteProject.service;

import com.spring.henallux.moumouteProject.model.CartItemDisplay;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CartServiceTest
{
    private CartService cartService;
    private ArrayList<CartItemDisplay> cartItemDisplays;

    @Before
    public void setUp() throws Exception {
        this.cartService = new CartService();
        cartItemDisplays = new ArrayList<>();
        cartItemDisplays.add(new CartItemDisplay(1, "Perruque 1", 5.5, 5, ""));
        cartItemDisplays.add(new CartItemDisplay(2, "Perruque 2", 10.40, 1, ""));
        cartItemDisplays.add(new CartItemDisplay(3, "Perruque 3", 15, 2, ""));
        cartItemDisplays.add(new CartItemDisplay(4, "Perruque 4", 10.40, 6, ""));
        cartItemDisplays.add(new CartItemDisplay(5, "Perruque 5", 2.6, 8, ""));
        cartItemDisplays.add(new CartItemDisplay(6, "Perruque 6", 6, 3, ""));
        cartItemDisplays.add(new CartItemDisplay(7, "Perruque 7", 7, 4, ""));
    }

    @Test
    public void getTotalPrice() throws Exception {
        Assert.assertEquals((5.5 * 5) + (10.40 * 1) + (15 * 2) + (10.40 * 6) + (2.6 * 8) + (6 * 3) + (7 * 4), cartService.getTotalPrice(cartItemDisplays), 1.0);
    }

    @Test
    public void getTotalQuantity() throws Exception {
        Assert.assertEquals(5 + 1 + 2 + 6 + 8 + 3 + 4, cartService.getTotalQuantity(cartItemDisplays));
    }
}
