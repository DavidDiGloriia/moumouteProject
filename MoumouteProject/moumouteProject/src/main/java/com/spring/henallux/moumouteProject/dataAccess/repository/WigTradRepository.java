package com.spring.henallux.moumouteProject.dataAccess.repository;


import com.spring.henallux.moumouteProject.dataAccess.entity.WigTradEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface WigTradRepository extends JpaRepository<WigTradEntity, Integer>
{
    public WigTradEntity findByLanguageCodeAndWigId(String lang, Integer wigId);
    public WigTradEntity findByLanguageCodeAndWigIdAndWigNameContaining(String lang, Integer wigId, String wigName);

}
