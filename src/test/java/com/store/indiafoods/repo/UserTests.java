package com.store.indiafoods.repo;

import com.store.indiafoods.model.Categories;
import com.store.indiafoods.model.Products;
import com.store.indiafoods.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserTests {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BCryptPasswordEncoder pwdEncoder;

    @Test
    public void getUsers(){
        List<User> users = userRepo.findAll();
        assertNotNull(users);
    }

    @Test
    public void getUserById(){
        User c = userRepo.findById(1).get();
        assertEquals("Sushmita", c.getFirstName());
        assertEquals("Inamdar", c.getLastName());
    }

    @Test
    public void testCreate(){
        User u = new User();
        u.setId(4);
        u.setEmail("junittest@gmail.com");
        u.setFirstName("JUnits");
        u.setLastName("Test");
        u.setPassword(pwdEncoder.encode("junit"));
        userRepo.save(u);
        assertNotNull(userRepo.findById(4).get());
    }
}
