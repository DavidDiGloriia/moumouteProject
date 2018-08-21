package com.spring.henallux.moumouteProject.dataAccess.dao;


import com.spring.henallux.moumouteProject.dataAccess.entity.PromotionEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.WigEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.WigTradEntity;
import com.spring.henallux.moumouteProject.dataAccess.repository.PromotionRepository;
import com.spring.henallux.moumouteProject.dataAccess.repository.WigRepository;
import com.spring.henallux.moumouteProject.dataAccess.repository.WigTradRepository;
import com.spring.henallux.moumouteProject.dataAccess.util.ProviderCenter;
import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;

@Service
@Transactional
public class WigDAO
{
    private WigRepository wigRepository;
    private WigTradRepository wigTradRepository;
    private PromotionRepository promotionRepository;
    private ProviderCenter providerCenter;

    @Autowired
    public WigDAO(WigRepository wigRepository,  WigTradRepository wigTradRepository, ProviderCenter providerCenter, PromotionRepository promotionRepository)
    {
        this.wigRepository = wigRepository;
        this.wigTradRepository = wigTradRepository;
        this.promotionRepository = promotionRepository;
        this.providerCenter = providerCenter;
    }

    public Wig getWigFromId(int id, String lang)
    {
        WigEntity wigEntity = wigRepository.findOne(id);
        WigTradEntity wigTradEntity = wigTradRepository.findByLanguageCodeAndWigId(lang, wigEntity.getId());
        PromotionEntity promotionEntity = promotionRepository.findFirstByIdAndEndDateLessThanEqual(wigEntity.getId(), new Date());
        return providerCenter.wigEntityAndWigTradEntityToWigModel(wigEntity, wigTradEntity,promotionEntity);
    }

    public ArrayList<Wig> getAllWigFromCategoryAndName(String category, String lang, String name) {

        ArrayList<WigEntity> wigEntities = new ArrayList<>();
        ArrayList<Wig> wigs = new ArrayList<Wig>();

        if(category.contains("all"))
        {
            wigEntities = wigRepository.findAll();
        }
        else
        {
            wigEntities = wigRepository.findByCategoryId(Integer.parseInt(category));
        }

        WigTradEntity tempWigTrad;


        for(WigEntity wigEntity : wigEntities)
        {
            tempWigTrad = wigTradRepository.findByLanguageCodeAndWigIdAndWigNameContaining(lang, wigEntity.getId(),name+"%");
            PromotionEntity promotionEntity = promotionRepository.findFirstByIdAndEndDateLessThanEqual(wigEntity.getId(), new Date());
            if(tempWigTrad != null)  wigs.add(providerCenter.wigEntityAndWigTradEntityToWigModel(wigEntity, tempWigTrad, promotionEntity));
        }

        return wigs;
    }

    public Wig getWigById(int id, String lang)
    {
        WigEntity wigEntity = wigRepository.findById(id);
        WigTradEntity wigTradEntity = wigTradRepository.findByLanguageCodeAndWigId(lang, wigEntity.getId());
        PromotionEntity promotionEntity = promotionRepository.findFirstByIdAndEndDateLessThanEqual(wigEntity.getId(), new Date());


        return providerCenter.wigEntityAndWigTradEntityToWigModel(wigEntity, wigTradEntity, promotionEntity);
    }
}
