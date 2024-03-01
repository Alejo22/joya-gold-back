package com.icfes.joyagold.service;

import java.util.List;

import com.icfes.joyagold.data.dto.ArchetypeDTO;
import com.icfes.joyagold.data.dto.MaterialDTO;

public interface DomainService {
    public List<MaterialDTO> getAllMaterials();
    public List<ArchetypeDTO> getAllArchetypes();
}
