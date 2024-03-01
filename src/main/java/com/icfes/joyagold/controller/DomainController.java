package com.icfes.joyagold.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icfes.joyagold.data.dto.ArchetypeDTO;
import com.icfes.joyagold.data.dto.MaterialDTO;

@RequestMapping(DomainController.PATH_BASE)
public interface DomainController {

    public static final String PATH_BASE = "/api/v1/domain";

    @GetMapping("/materials")
    public ResponseEntity<List<MaterialDTO>> getMaterials();

    @GetMapping("/archetypes")
    public ResponseEntity<List<ArchetypeDTO>> getArchetypes();
}
