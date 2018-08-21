package com.spring.henallux.moumouteProject.dataAccess.dao;

import com.spring.henallux.moumouteProject.dataAccess.entity.UserEntity;
import com.spring.henallux.moumouteProject.dataAccess.repository.SaleLineRepository;
import com.spring.henallux.moumouteProject.dataAccess.repository.SaleRepository;
import com.spring.henallux.moumouteProject.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;


@Service
@Transactional
public class SaleDAO
{

    private WigDAO wigDAO;
    private SaleRepository saleRepository;
    private SaleLineRepository saleLineRepository;

    @Autowired
    public SaleDAO(WigDAO wigDAO, SaleRepository saleRepository, SaleLineRepository saleLineRepository)
    {
        this.wigDAO = wigDAO;
        this.saleRepository = saleRepository;
        this.saleLineRepository = saleLineRepository;
    }

    public void saveSale(UserEntity userEntity, HashMap<Integer,CartItem> cart)
    {

    }
}
