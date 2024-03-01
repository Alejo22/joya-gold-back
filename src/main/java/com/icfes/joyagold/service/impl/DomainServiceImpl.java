package com.icfes.joyagold.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icfes.joyagold.data.dto.ArchetypeDTO;
import com.icfes.joyagold.data.dto.MaterialDTO;
import com.icfes.joyagold.data.factory.DomainFactory;
import com.icfes.joyagold.repository.ArchetypeRepository;
import com.icfes.joyagold.repository.MaterialRepository;
import com.icfes.joyagold.service.DomainService;

@Service
public class DomainServiceImpl  implements DomainService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ArchetypeRepository archetypeRepository;

    @Override
    public List<MaterialDTO> getAllMaterials() {
        return this.materialRepository.findAll().stream().map( material -> DomainFactory.entityToDTO(material)).collect(Collectors.toList());
    }

    @Override
    public List<ArchetypeDTO> getAllArchetypes() {
        return this.archetypeRepository.findAll().stream().map( archetype -> DomainFactory.entityToDTO(archetype)).collect(Collectors.toList());
    }

}
