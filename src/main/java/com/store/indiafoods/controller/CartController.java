package com.store.indiafoods.controller;

import com.store.indiafoods.global.GlobalData;
import com.store.indiafoods.model.Products;
import com.store.indiafoods.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DecimalFormat;

@Controller
public class CartController {
    @Autowired
    ProductService productService;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id){
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String getCart(Model model){
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("total",df.format(GlobalData.cart.stream().mapToDouble(Products::getP_price).sum()));
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index){
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("total",df.format(GlobalData.cart.stream().mapToDouble(Products::getP_price).sum()));
        return "/checkout";
    }

}
