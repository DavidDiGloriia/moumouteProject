package com.spring.henallux.moumouteProject.dataAccess.repository;

import com.spring.henallux.moumouteProject.dataAccess.entity.WigEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.WigTradEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface WigRepository extends JpaRepository<WigEntity, Integer>
{
    public ArrayList<WigEntity> findByCategoryId(Integer categoryId);
    public WigEntity findById(Integer id);
    public ArrayList<WigEntity> findAll();
}
