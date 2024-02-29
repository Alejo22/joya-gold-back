package com.icfes.joyagold.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.icfes.joyagold.controller.ProductController;
import com.icfes.joyagold.data.model.Product;
import com.icfes.joyagold.service.ProductService;

@RestController
public class ProductControllerImpl  implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    public void create(Product product) {
        this.productService.saveOrUpdate(product);
    }

    @Override
    public ResponseEntity<Product> getById(Integer productId) {
        return ResponseEntity.ok( this.productService.getById(productId) );
    }

    @Override
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(this.productService.getAll());
    }

}
