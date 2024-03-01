package com.icfes.joyagold.data.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ProductDTO {    
	private Integer id;
	private String name;
	private Integer weight;
	private BigDecimal price;
	private String color;
	private Integer materiaId;
	private MaterialDTO material;
	private Integer archetypeId;
	private ArchetypeDTO archetype;
}
