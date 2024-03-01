package com.icfes.joyagold.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.icfes.joyagold.controller.ProductController;
import com.icfes.joyagold.data.dto.ProductDTO;
import com.icfes.joyagold.service.ProductService;

@RestController
public class ProductControllerImpl  implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<ProductDTO> create(ProductDTO productDTO) {
        return new ResponseEntity<ProductDTO>(this.productService.create(productDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductDTO> update(ProductDTO productDTO) {
        return ResponseEntity.ok(this.productService.update(productDTO));
    }

    @Override
    public void delete(Integer productId) {
        this.productService.delete(productId);
    }

    @Override
    public ResponseEntity<ProductDTO> getById(Integer productId) {
        return ResponseEntity.ok( this.productService.getById(productId) );
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(this.productService.getAll());
    }
}
