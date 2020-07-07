package com.gin.service;

import com.gin.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpI implements ProductService {
    private static Map<Integer, Product>products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Samsung j1","Hanoi",3000000.0));
        products.put(2,new Product(2,"Iphone X","Hanoi",9000000.0));
        products.put(3,new Product(3,"7-color shorts UwU","Thainguyen",7777777.7));
        products.put(4,new Product(4,"ram 8gb","TP.HCM",900000.0));
    }
    @Override
    public List findAll(){
        return new ArrayList<>(products.values());
    }
    @Override
    public void save(Product product){
        int length = products.size() + 1;
        product.setId(length);
        products.put(product.getId(),product);
    }
    @Override
    public Product findById(int id){
        return products.get(id);
    }
    @Override
    public void update(int id,Product product){
        products.put(id,product);
    }
    @Override
    public void remove(int id){
        products.remove(id);
    }
}
