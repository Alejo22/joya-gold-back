package com.icfes.joyagold.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.icfes.joyagold.controller.DomainController;
import com.icfes.joyagold.data.dto.ArchetypeDTO;
import com.icfes.joyagold.data.dto.MaterialDTO;
import com.icfes.joyagold.service.DomainService;

@RestController
public class DomainControllerImpl  implements DomainController{

    @Autowired
    private DomainService domainService;

    @Override
    public ResponseEntity<List<MaterialDTO>> getMaterials() {
        return ResponseEntity.ok(this.domainService.getAllMaterials());
    }

    @Override
    public ResponseEntity<List<ArchetypeDTO>> getArchetypes() {
        return ResponseEntity.ok(this.domainService.getAllArchetypes());
    }

}
