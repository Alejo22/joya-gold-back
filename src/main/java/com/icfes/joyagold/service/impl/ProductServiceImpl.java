package com.icfes.joyagold.service.impl;

import java.util.Date;
import java.util.List;
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
    public void saveOrUpdate(ProductDTO productDTO) {
        if( productDTO.getId() != null && productDTO.getId() > 0){
            this.productRepository.save(this.update(productDTO));
        }else{
            this.productRepository.save(this.save(productDTO));
        }
    }

    @Override
    public ProductDTO getById(Integer id) {
        Product product = this.productRepository.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("id", "Product", id.toString(), ErrorCodeEnum.NOT_FOUND_RESOURCE.getValue()) );
        
        return ProductFactory.entityToDTO(product);
    }

    @Override
    public List<ProductDTO> getAll() {
        return this.productRepository.findAll()
            .stream()
            .map( product -> ProductFactory.entityToDTO(product ))
            .collect(Collectors.toList());
    }

    private Product save(ProductDTO productDTO){
        
        Integer materialId = productDTO.getMaterialId();
        Material material = this.materialRepository.findById(materialId)
            .orElseThrow( () -> new ResourceNotFoundException("id", "Material", materialId.toString(), ErrorCodeEnum.NOT_FOUND_RESOURCE.getValue()) );

        Integer archetypeId = productDTO.getArchetypeId();
        Archetype archetype = this.archetypeRepository.findById(archetypeId)
        .orElseThrow( () -> new ResourceNotFoundException("id", "Archetype", archetypeId.toString(), ErrorCodeEnum.NOT_FOUND_RESOURCE.getValue()) );

        Product newProduct = ProductFactory.DTOToEntity(productDTO);
        newProduct.setMaterial(material);
        newProduct.setArchetype(archetype);

        Date creationDate = new Date();
        newProduct.setCreationDate(creationDate);
        newProduct.setUpdateDate(creationDate);

        return newProduct;
    }

    private Product update(ProductDTO productDTO){

        Integer id = productDTO.getId();

        Product product = this.productRepository.findById(id)
        .orElseThrow( () -> new ResourceNotFoundException("id", "Product", id.toString(), ErrorCodeEnum.NOT_FOUND_RESOURCE.getValue()) );

        Integer archetypeId = productDTO.getArchetypeId();
        Archetype archetype = this.archetypeRepository.findById(archetypeId)
        .orElseThrow( () -> new ResourceNotFoundException("id", "Archetype", archetypeId.toString(), ErrorCodeEnum.NOT_FOUND_RESOURCE.getValue()) );

        product.setPrice(productDTO.getPrice());
        product.setArchetype(archetype);

        Date creationDate = new Date();
        product.setUpdateDate(creationDate);

        return product;
    }
}
