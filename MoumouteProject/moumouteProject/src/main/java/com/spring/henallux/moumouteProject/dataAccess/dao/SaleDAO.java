package com.spring.henallux.moumouteProject.dataAccess.dao;

import com.spring.henallux.moumouteProject.dataAccess.entity.SaleEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.SaleLineEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.UserEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.WigEntity;
import com.spring.henallux.moumouteProject.dataAccess.repository.SaleLineRepository;
import com.spring.henallux.moumouteProject.dataAccess.repository.SaleRepository;
import com.spring.henallux.moumouteProject.model.CartItem;
import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
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
        SaleEntity sale = new SaleEntity(new Date(), userEntity);
        SaleEntity dbSale = saleRepository.save(sale);
        for(CartItem cartItem : cart.values())
        {
            Wig wig = wigDAO.getWigById(cartItem.getItemId(), "EN"); // Language doesn't matter here since we won't use name and description for the bill
            SaleLineEntity saleLineEntity = new SaleLineEntity();
            WigEntity wigEntity = new WigEntity();
            wigEntity.setId(wig.getId());

            saleLineEntity.setQuantity(cartItem.getQuantity());
            saleLineEntity.setUnitPrice(wig.getPromotion() == null ? wig.getEVATPrice() * (1 + (wig.getVATRate()/100)) : (wig.getEVATPrice() * (1 + (wig.getVATRate()/100))) * (1 - (wig.getPromotion().getPercRed() / 100)));
            saleLineEntity.setSale(dbSale);
            saleLineEntity.setWig(wigEntity);

            saleLineRepository.save(saleLineEntity);
        }
    }
}
