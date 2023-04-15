package com.store.indiafoods.repo;

import com.store.indiafoods.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {
    public List<Products> findAllByCategories_Id(int c_id);
}
