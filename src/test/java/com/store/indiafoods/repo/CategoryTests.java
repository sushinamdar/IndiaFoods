package com.store.indiafoods.repo;

import com.store.indiafoods.model.Categories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CategoryTests {

    @Autowired
    CategoryRepo categoryRepo;

    @Test
    public void getCategory(){
        List<Categories> categories = categoryRepo.findAll();
        assertNotNull(categories);
    }

    @Test
    public void getCategoryById(){
        Categories c = categoryRepo.findById(2).get();
        assertEquals("Vegetables", c.getC_name());
    }

   /* @Test
    public void testCreate(){
        Categories c = new Categories();
        c.setId(4);
        c.setC_name("Meat");

        categoryRepo.save(c);
        assertNotNull(categoryRepo.findById(4).get());
    }*/

}
