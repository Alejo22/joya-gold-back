package com.icfes.joyagold.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icfes.joyagold.data.model.Material;
import com.icfes.joyagold.repository.MaterialRepository;
import com.icfes.joyagold.service.DomainService;

@Service
public class DomainServiceImpl  implements DomainService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> getAllMaterials() {
        return this.materialRepository.findAll();
    }

}
