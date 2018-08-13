package com.spring.henallux.moumouteProject.dataAccess.repository;


import com.spring.henallux.moumouteProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.CategoryTradEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>
{


}
