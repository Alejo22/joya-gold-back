package com.icfes.joyagold.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icfes.joyagold.data.dto.ProductDTO;
import com.icfes.joyagold.data.factory.ProductFactory;
import com.icfes.joyagold.data.model.Archetype;
import com.icfes.joyagold.data.model.Material;
import com.icfes.joyagold.data.model.Product;
import com.icfes.joyagold.exceptions.ResourceNotFoundException;
import com.icfes.joyagold.repository.ArchetypeRepository;
import com.icfes.joyagold.repository.MaterialRepository;
import com.icfes.joyagold.repository.ProductRepository;
import com.icfes.joyagold.service.ProductService;
import com.icfes.joyagold.util.ErrorCodeEnum;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    ArchetypeRepository archetypeRepository;

    @Override
    public ProductDTO getById(Integer id) {
        Product product = this.productRepository.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("id", "Product", id.toString(), ErrorCodeEnum.NOT_FOUND_RESOURCE.getValue()) );
        
        return ProductFactory.entityToDTO(product);
    }

    @Override
    public void saveOrUpdate(ProductDTO product) {


       /*  Material material = this.materialRepository.findById(1).get();
        Archetype archetype = this.archetypeRepository.findById(1).get(); */

       /*  product.setMaterial(material);
        product.setArchetype(archetype);

        Date creationDate = new Date();
        product.setCreationDate(creationDate);
        product.setUpdateDate(creationDate);

        System.out.println(product.toString());

        this.productRepository.save(product); */
    }

    @Override
    public List<ProductDTO> getAll() {
        return this.productRepository.findAll()
            .stream()
            .map( product -> ProductFactory.entityToDTO(product ))
            .collect(Collectors.toList());
    }
}
