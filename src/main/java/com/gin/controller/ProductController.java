package com.gin.controller;

import com.gin.model.Product;
import com.gin.service.ProductService;
import com.gin.service.ProductServiceImpI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService =new ProductServiceImpI();
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        List productList = productService.findAll();
        modelAndView.addObject("product",productList);
        return modelAndView;
    }
    @GetMapping("/product/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("/product/save")
    public ModelAndView save(Product product){
        productService.save(product);
        ModelAndView modelAndView = index();
        return modelAndView;
    }
    @GetMapping("/product/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }
    @PostMapping("/product/update")
    public ModelAndView update(Product product){
        productService.update(product.getId(),product);
        ModelAndView modelAndView = index();
        return modelAndView;
    }
    @GetMapping("product/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }
    @PostMapping("/product/delete")
    public ModelAndView delete(Product product){
        productService.remove(product.getId());
        ModelAndView modelAndView = index();
        return modelAndView;
    }
    @GetMapping("/product/{id}/view")
    public ModelAndView view(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }
}
