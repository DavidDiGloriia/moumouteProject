package com.spring.henallux.moumouteProject.dataAccess.dao;

import com.spring.henallux.moumouteProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.moumouteProject.dataAccess.entity.CategoryTradEntity;
import com.spring.henallux.moumouteProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.moumouteProject.dataAccess.repository.CategoryTradRepository;
import com.spring.henallux.moumouteProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDAO {

    private CategoryTradRepository categoryTradRepository;
    private CategoryRepository     categoryRepository;

    @Autowired
    public CategoryDAO(CategoryTradRepository categoryTradRepository)
    {
        this.categoryTradRepository = categoryTradRepository;
    }

    public ArrayList<Category> getAllCategories()
    {
        List<CategoryTradEntity> categoriesTradEntities = categoryTradRepository.findByLanguageCode("FR");


        ArrayList<Category> output = new ArrayList<>();

        for(CategoryTradEntity categoryTradEntity : categoriesTradEntities)
        {
            output.add(new Category(categoryTradEntity.getCategory().getId(),categoryTradEntity.getCategoryName()));
        }

        return output;

    }
}
