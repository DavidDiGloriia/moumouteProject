package com.spring.henallux.moumouteProject.dataAccess.dao;


import com.spring.henallux.moumouteProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.moumouteProject.dataAccess.repository.LanguageRepository;
import com.spring.henallux.moumouteProject.dataAccess.util.ProviderCenter;
import com.spring.henallux.moumouteProject.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class LanguageDAO
{
    private LanguageRepository languageRepository;
    private ProviderCenter providerCenter;

    @Autowired
    public LanguageDAO(LanguageRepository languageRepository, ProviderCenter providerCenter)
    {
        this.languageRepository = languageRepository;
        this.providerCenter = providerCenter;
    }

    public ArrayList<Language> getAllLanguages()
    {
        ArrayList<LanguageEntity> languageEntities = languageRepository.findAll();
        ArrayList<Language> languages = new ArrayList<Language>();
        for(LanguageEntity languageEntity : languageEntities)
        {
            languages.add(providerCenter.languageEntityToLanguageModel(languageEntity));
        }
        return languages;
    }
}
