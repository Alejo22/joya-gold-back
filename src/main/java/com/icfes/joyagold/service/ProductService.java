package com.icfes.joyagold.service;

import java.util.List;

import com.icfes.joyagold.data.dto.ProductDTO;

public interface ProductService {
    public void create(ProductDTO productDTO);
    public void update(ProductDTO productDTO);
    public void delete(Integer productId);
    public ProductDTO getById(Integer id);
    public List<ProductDTO> getAll();
}
