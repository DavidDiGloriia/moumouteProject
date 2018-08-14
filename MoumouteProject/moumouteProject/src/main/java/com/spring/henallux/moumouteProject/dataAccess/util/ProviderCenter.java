package com.spring.henallux.moumouteProject.dataAccess.util;

import com.spring.henallux.moumouteProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.UserEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.WigEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.WigTradEntity;
import com.spring.henallux.moumouteProject.model.Language;
import com.spring.henallux.moumouteProject.model.User;
import com.spring.henallux.moumouteProject.model.UserRegisterForm;
import com.spring.henallux.moumouteProject.model.Wig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public UserEntity userRegisterFormToUserEntity(UserRegisterForm userRegisterForm)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setAuthorities("ROLE_USER");
        userEntity.setNon_Expired(true);
        userEntity.setNon_Locked(true);
        userEntity.setCredentials_Non_Expired(true);
        userEntity.setEnabled(true);
        userEntity.setUsername(userRegisterForm.getUsername());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userRegisterForm.getPassword()));
        userEntity.setLastname(userRegisterForm.getLastname());
        userEntity.setFirstname(userRegisterForm.getFirstname());
        userEntity.setEmail(userRegisterForm.getEmail());
        userEntity.setStreet(userRegisterForm.getStreet());
        userEntity.setPostalCode(Integer.parseInt(userRegisterForm.getPostalCode()));
        userEntity.setCity(userRegisterForm.getCity());
        userEntity.setCountry(userRegisterForm.getCountry());
        return userEntity;

    }
}
