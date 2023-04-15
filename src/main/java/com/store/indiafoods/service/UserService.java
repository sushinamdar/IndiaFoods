package com.store.indiafoods.service;

import com.store.indiafoods.model.User;
import com.store.indiafoods.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void save(User user){
        userRepo.save(user);
    }
}
