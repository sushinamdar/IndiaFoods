package com.store.indiafoods.service;

import com.store.indiafoods.model.Products;
import com.store.indiafoods.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public List<Products> getAllProducts(){
        return productRepo.findAll();
    }

    public Optional<Products> getProductById(long p_id){
        return productRepo.findById(p_id);
    }

    public List<Products> getProductsByCategoryId(int c_id){
        return productRepo.findAllByCategories_Id(c_id);
    }
}
