package com.icfes.joyagold.service;

import java.util.List;

import com.icfes.joyagold.data.model.Archetype;
import com.icfes.joyagold.data.model.Material;

public interface DomainService {
    public List<Material> getAllMaterials();
    public List<Archetype> getAllArchetypes();
}
