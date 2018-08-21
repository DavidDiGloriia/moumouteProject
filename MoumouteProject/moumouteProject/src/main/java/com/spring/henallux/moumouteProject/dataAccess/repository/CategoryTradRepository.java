package com.spring.henallux.moumouteProject.dataAccess.repository;


import com.spring.henallux.moumouteProject.dataAccess.entity.CategoryTradEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.WigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryTradRepository extends JpaRepository<CategoryTradEntity, Integer>
{
    public CategoryTradEntity findByCategoryId(Integer categoryId);
    public List<CategoryTradEntity> findByLanguageCode(String code);

}
