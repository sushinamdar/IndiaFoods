package com.store.indiafoods.controller;

import com.store.indiafoods.global.GlobalData;
import com.store.indiafoods.service.CategoryService;
import com.store.indiafoods.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }

    @GetMapping({"/shop"})
    public String shop(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("products",productService.getProductsByCategoryId(id));
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product", productService.getProductById(id).get());
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "viewProduct";
    }

}
