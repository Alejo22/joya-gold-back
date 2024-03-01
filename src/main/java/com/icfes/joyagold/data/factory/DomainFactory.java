package com.icfes.joyagold.data.factory;

import com.icfes.joyagold.data.dto.ArchetypeDTO;
import com.icfes.joyagold.data.dto.MaterialDTO;
import com.icfes.joyagold.data.model.Archetype;
import com.icfes.joyagold.data.model.Material;

public class DomainFactory {

    public static MaterialDTO entityToDTO(Material material){
        if( material == null){
            return new MaterialDTO();
        }

        return MaterialDTO.builder().id(material.getId()).name(material.getName()).build();
    }

    public static ArchetypeDTO entityToDTO(Archetype archetype){
        if( archetype == null){
            return new ArchetypeDTO();
        }

        return ArchetypeDTO.builder().id(archetype.getId()).name(archetype.getName()).build();
    }

}
