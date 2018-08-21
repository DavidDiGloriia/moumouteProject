package com.spring.henallux.moumouteProject.controller;

import com.spring.henallux.moumouteProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.moumouteProject.model.CartItem;
import com.spring.henallux.moumouteProject.model.Constants;
import com.spring.henallux.moumouteProject.model.SearchWigForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

@ControllerAdvice
@SessionAttributes({Constants.CART})
public class TemplateController extends HandlerInterceptorAdapter {

    private ConcurrentHashMap<String, LongAdder> counterMap = new ConcurrentHashMap<>();

    private final MessageSource messageSource;
    private CategoryDAO categoryDAO;

    @ModelAttribute(Constants.CART)
    public HashMap<Integer,CartItem> cart(){
        return new HashMap<>();
    }

    @Autowired
    public TemplateController(MessageSource messageSource, CategoryDAO categoryDAO)
    {
        this.categoryDAO = categoryDAO;
        this.messageSource = messageSource;
    }

    @ModelAttribute
    public void handleRequest(Model model, Locale locale, @ModelAttribute(value = Constants.CART)HashMap<Integer, CartItem> cart)
    {
        //populating request URI in the model
        model.addAttribute("categories", categoryDAO.getAllCategories(locale.getLanguage()));
        model.addAttribute("itemToSearch", new SearchWigForm());
        model.addAttribute("cartSize", cart.size());
        model.addAttribute("title", messageSource.getMessage("home_title",null,locale));
    }

}
