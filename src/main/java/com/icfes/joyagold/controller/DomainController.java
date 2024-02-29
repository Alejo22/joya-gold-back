package com.icfes.joyagold.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icfes.joyagold.data.model.Material;

@RequestMapping(DomainController.PATH_BASE)
public interface DomainController {

    public static final String PATH_BASE = "/api/v1/domain";

    @GetMapping("/materials")
    public List<Material> getMaterials();
}
