package com.spring.henallux.moumouteProject.dataAccess.util;

import com.spring.henallux.moumouteProject.dataAccess.entity.*;
import com.spring.henallux.moumouteProject.model.*;
import com.sun.istack.internal.Nullable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ProviderCenter
{
    public Wig wigEntityAndWigTradEntityToWigModel(WigEntity wigEntity, WigTradEntity wigTradEntity, @Nullable PromotionEntity promotionEntity)
    {
        Wig wigModel = new Wig();
        wigModel.setId(wigEntity.getId());
        wigModel.setEVATPrice(wigEntity.getEVATPrice());
        wigModel.setVATRate(wigEntity.getVATRate());
        wigModel.setPictureLink(wigEntity.getPictureLink());
        wigModel.setWigName(wigTradEntity.getWigName());
        wigModel.setDescription(wigTradEntity.getDescription());
        wigModel.setCategoryId(wigEntity.getCategory().getId());
        if(promotionEntity != null)
        {
            wigModel.setPromotion(this.PromotionEntityToPromotionModel(promotionEntity));
        }
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
        userEntity.setPhoneNumber(userRegisterForm.getPhoneNumber());
        return userEntity;
    }

    public Promotion PromotionEntityToPromotionModel(PromotionEntity promotionEntity)
    {
        return new Promotion(
                promotionEntity.getStartDate(),
                promotionEntity.getEndDate(),
                promotionEntity.getPercRed()
        );
    }
}
