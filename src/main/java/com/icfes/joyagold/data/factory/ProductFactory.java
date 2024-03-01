package com.icfes.joyagold.data.factory;

import com.icfes.joyagold.data.dto.ProductDTO;
import com.icfes.joyagold.data.model.Product;

public class ProductFactory {

    public static ProductDTO entityToDTO(Product product){
        if( product == null){
            return new ProductDTO();
        }

        return ProductDTO.builder()
            .id(product.getId())
            .name(product.getName())
            .weight(product.getWeight())
            .price(product.getPrice())
            .color(product.getColor())
            .material( DomainFactory.entityToDTO(product.getMaterial()))
            .archetype(DomainFactory.entityToDTO(product.getArchetype()))
            .build();
    }

    public static Product DTOToEntity(ProductDTO productDTO){
        if( productDTO == null){
            return new Product();
        }

        return Product.builder()
            .name(productDTO.getName())
            .weight(productDTO.getWeight())
            .price(productDTO.getPrice())
            .color(productDTO.getColor())
            .build();
    }

}
