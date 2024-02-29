package com.icfes.joyagold.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icfes.joyagold.data.model.Archetype;
import com.icfes.joyagold.data.model.Material;
import com.icfes.joyagold.data.model.Product;
import com.icfes.joyagold.repository.ArchetypeRepository;
import com.icfes.joyagold.repository.MaterialRepository;
import com.icfes.joyagold.repository.ProductRepository;
import com.icfes.joyagold.service.ProductService;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    ArchetypeRepository archetypeRepository;

    @Override
    public Product getById(Integer id) {
        //TODO: Ajustar a DTO
        Product product = this.productRepository.findById(id).get();
        return product;
    }

    @Override
    public void saveOrUpdate(Product product) {
        //TODO: Ajustar a DTO
        Material material = this.materialRepository.findById(1).get();
        Archetype archetype = this.archetypeRepository.findById(1).get();

        product.setMaterial(material);
        product.setArchetype(archetype);

        Date creationDate = new Date();
        product.setCreationDate(creationDate);
        product.setUpdateDate(creationDate);

        System.out.println(product.toString());

        this.productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
}
