package com.icfes.joyagold.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icfes.joyagold.data.dto.ProductDTO;

@RequestMapping(ProductController.PATH_BASE)
public interface ProductController {
    public static final String PATH_BASE = "/api/v1/product";

    @PostMapping()
    public void create(@RequestBody ProductDTO product);

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAll();

    @GetMapping(value={"/{productId}"})
    public ResponseEntity<ProductDTO> getById(@PathVariable("productId") Integer productId );
}
