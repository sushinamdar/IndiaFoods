package com.store.indiafoods.service;

import com.store.indiafoods.model.Categories;
import com.store.indiafoods.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public void addCategory(Categories category){
        categoryRepo.save(category);
    }

    public List<Categories> getAllCategories(){
        return categoryRepo.findAll();
    }
}
