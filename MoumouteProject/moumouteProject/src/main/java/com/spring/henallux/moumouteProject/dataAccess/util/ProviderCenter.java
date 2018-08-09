package com.spring.henallux.moumouteProject.dataAccess.util;

import com.spring.henallux.moumouteProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.WigEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.WigTradEntity;
import com.spring.henallux.moumouteProject.model.Language;
import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.stereotype.Component;

@Component
public class ProviderCenter
{
    public Wig wigEntityAndWigTradEntityToWigModel(WigEntity wigEntity, WigTradEntity wigTradEntity)
    {
        Wig wigModel = new Wig();
        wigModel.setId(wigEntity.getId());
        wigModel.setEVATPrice(wigEntity.getEVATPrice());
        wigModel.setVATRate(wigEntity.getVATRate());
        wigModel.setMan(wigEntity.isMan());
        wigModel.setWigName(wigTradEntity.getWigName());
        wigModel.setDescription(wigTradEntity.getDescription());
        wigModel.setCategoryId(wigEntity.getCategory().getId());
        return wigModel;
    }

    public Language languageEntityToLanguageModel(LanguageEntity languageEntity)
    {
        return new Language(languageEntity.getCode());
    }
}
