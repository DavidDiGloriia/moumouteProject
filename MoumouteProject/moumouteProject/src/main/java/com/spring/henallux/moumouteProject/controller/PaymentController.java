package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.moumouteProject.dataAccess.dao.SaleDAO;
import com.spring.henallux.moumouteProject.dataAccess.entity.UserEntity;
import com.spring.henallux.moumouteProject.model.CartItem;
import com.spring.henallux.moumouteProject.model.Constants;
import com.spring.henallux.moumouteProject.model.SearchWigForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/payment")
@SessionAttributes({Constants.CART})
public class PaymentController
{

    private SaleDAO saleDAO;

    @Autowired
    public PaymentController(SaleDAO saleDAO)
    {
        this.saleDAO = saleDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String payment(Model model, Locale locale)
    {
        return "integrated:payment";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/paymentSucceed")
    public String paymentSucceed(@ModelAttribute(value= Constants.CART) HashMap<Integer,CartItem> cart, Authentication authentication)
    {
        saleDAO.saveSale((UserEntity)authentication.getPrincipal(), cart);
        cart.clear();
        return "redirect:/home";
    }
}
