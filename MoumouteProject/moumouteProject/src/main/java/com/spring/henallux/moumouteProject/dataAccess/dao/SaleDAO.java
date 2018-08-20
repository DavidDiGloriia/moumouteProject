package com.spring.henallux.moumouteProject.dataAccess.dao;

import com.spring.henallux.moumouteProject.dataAccess.entity.UserEntity;
import com.spring.henallux.moumouteProject.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;


@Service
@Transactional
public class SaleDAO
{
    private SaleLineDAO saleLineDAO;

    @Autowired
    public SaleDAO(SaleLineDAO saleLineDAO)
    {
        this.saleLineDAO = saleLineDAO;
    }

    public void saveSale(UserEntity userEntity, HashMap<Integer,CartItem> cart)
    {

    }
}
