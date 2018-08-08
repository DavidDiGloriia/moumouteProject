package com.spring.henallux.moumouteProject.dataAccess.dao;


import com.spring.henallux.moumouteProject.dataAccess.entity.WigEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.WigTradEntity;
import com.spring.henallux.moumouteProject.dataAccess.repository.WigColorRepository;
import com.spring.henallux.moumouteProject.dataAccess.repository.WigRepository;
import com.spring.henallux.moumouteProject.dataAccess.repository.WigTradRepository;
import com.spring.henallux.moumouteProject.dataAccess.util.ProviderCenter;
import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class WigDAO
{
    private WigRepository wigRepository;
    private WigColorRepository wigColorRepository;
    private WigTradRepository wigTradRepository;
    private ProviderCenter providerCenter;

    @Autowired
    public WigDAO(WigRepository wigRepository, WigColorRepository wigColorRepository, WigTradRepository wigTradRepository, ProviderCenter providerCenter) {
        this.wigRepository = wigRepository;
        this.wigColorRepository = wigColorRepository;
        this.wigTradRepository = wigTradRepository;
        this.providerCenter = providerCenter;
    }

    public ArrayList<Wig> getAllWigFromCategory(int categoryId, String lang) {
        ArrayList<WigEntity> wigEntities = wigRepository.findByCategoryId(categoryId);
        ArrayList<Wig> wigs = new ArrayList<Wig>();
        WigTradEntity tempWigTrad;
        for(WigEntity wigEntity : wigEntities) {
            tempWigTrad = wigTradRepository.findByLanguageCodeAndWigId(lang, wigEntity.getId());
            wigs.add(providerCenter.wigEntityAndWigTradEntityToWigModel(wigEntity, tempWigTrad));
        }
        return wigs;
    }
}
