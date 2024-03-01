package com.icfes.joyagold.service;

import java.util.List;

import com.icfes.joyagold.data.dto.ProductDTO;

public interface ProductService {
    public ProductDTO getById(Integer id);
    public List<ProductDTO> getAll();
    public void saveOrUpdate(ProductDTO product);
}
