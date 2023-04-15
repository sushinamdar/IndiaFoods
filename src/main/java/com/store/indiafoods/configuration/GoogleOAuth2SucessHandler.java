package com.store.indiafoods.configuration;

import com.store.indiafoods.model.AuthenticationProvider;
import com.store.indiafoods.model.Role;
import com.store.indiafoods.model.User;
import com.store.indiafoods.repo.RoleRepo;
import com.store.indiafoods.repo.UserRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class GoogleOAuth2SucessHandler implements AuthenticationSuccessHandler {
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    UserRepo userRepo;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);

        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String email = token.getPrincipal().getAttributes().get("email").toString();
        if(!userRepo.findUserByEmail(email).isPresent()){
            User user = new User();
            user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
            user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
            user.setEmail(email);
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepo.findById(2).get());
            user.setRoles((Set<Role>) roles);
            user.setAuthProvider(AuthenticationProvider.GOOGLE);
            userRepo.save(user);
        }
        else{
            //Update the user's details
            User user = userRepo.findUserByEmail(email).get();
            user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
            user.setAuthProvider(AuthenticationProvider.GOOGLE);
            userRepo.save(user);

        }
        redirectStrategy.sendRedirect(request, response, "/");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

    }

}
