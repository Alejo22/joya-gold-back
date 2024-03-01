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

}
