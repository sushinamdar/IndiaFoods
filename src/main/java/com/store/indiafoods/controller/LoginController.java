package com.store.indiafoods.controller;

import com.store.indiafoods.global.GlobalData;
import com.store.indiafoods.model.Role;
import com.store.indiafoods.model.User;
import com.store.indiafoods.repo.RoleRepo;
import com.store.indiafoods.repo.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class LoginController {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/login")
    public String login(){
        GlobalData.cart.clear();
        return "login";

    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";

    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepo.findById(2).get());
        user.setRoles(roles);
        userRepo.save(user);
        request.login(user.getEmail(), password);
        return "redirect:/";
    }
}
