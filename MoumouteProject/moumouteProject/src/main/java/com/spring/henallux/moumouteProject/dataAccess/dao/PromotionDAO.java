package com.spring.henallux.moumouteProject.dataAccess.dao;


import com.spring.henallux.moumouteProject.dataAccess.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PromotionDAO
{
    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionDAO(PromotionRepository promotionRepository)
    {
        this.promotionRepository = promotionRepository;
    }
}
