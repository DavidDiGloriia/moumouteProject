package com.spring.henallux.moumouteProject.dataAccess.repository;


import com.spring.henallux.moumouteProject.dataAccess.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface LanguageRepository extends JpaRepository<LanguageEntity, String>
{
    public ArrayList<LanguageEntity> findAll();
}
