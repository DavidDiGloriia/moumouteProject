package com.spring.henallux.moumouteProject.dataAccess.dao;

import com.spring.henallux.moumouteProject.dataAccess.entity.UserEntity;
import com.spring.henallux.moumouteProject.dataAccess.repository.UserRepository;
import com.spring.henallux.moumouteProject.dataAccess.util.ProviderCenter;
import com.spring.henallux.moumouteProject.model.UserRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserDAO
{
    private UserRepository userRepository;
    private ProviderCenter providerCenter;


    @Autowired
    public UserDAO(UserRepository userRepository, ProviderCenter providerCenter) {
        this.userRepository = userRepository;
        this.providerCenter = providerCenter;
    }

    public boolean isUsernameUsed(String username)
    {
        return (userRepository.findByUsername(username) != null);
    }

    public boolean isEmailUser(String email)
    {
        return (userRepository.findByEmail(email) != null);
    }

    public boolean registerUser(UserRegisterForm userRegisterForm)
    {
        UserEntity userEntity = userRepository.save(providerCenter.userRegisterFormToUserEntity(userRegisterForm));
        return userEntity != null;
    }
}
