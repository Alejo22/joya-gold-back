package com.icfes.joyagold.service;

import java.util.List;

import com.icfes.joyagold.data.model.Product;

public interface ProductService {
    public Product getById(Integer id);
    public List<Product> getAll();
    public void saveOrUpdate(Product product);
}
