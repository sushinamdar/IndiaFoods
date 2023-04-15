package com.store.indiafoods.repo;

import com.store.indiafoods.model.Categories;
import com.store.indiafoods.model.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductTests {
    @Autowired ProductRepo productRepo;

    @Test
    public void getProducts(){
        List<Products> products = productRepo.findAll();
        assertNotNull(products);
    }

    @Test
    public void getProductById(){
        Products p = productRepo.findById(2L).get();
        assertEquals("Haldirams Aloo Bhujia - 1kg", p.getP_name());
        assertEquals(13.99, p.getP_price());
    }

    @Test
    public void testCreate(){
        Products p = new Products();
        p.setP_id(10L);
        p.setP_name("MDH Pani puri masala");
        p.setP_price(2.29);
        p.setP_weight(100.00);
        Categories c = new Categories();
        c.setId(1);
        p.setCategories(c);
        productRepo.save(p);
        assertNotNull(productRepo.findById(10L).get());
    }


}
