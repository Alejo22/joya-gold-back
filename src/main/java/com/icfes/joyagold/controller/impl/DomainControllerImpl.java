package com.icfes.joyagold.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.icfes.joyagold.controller.DomainController;
import com.icfes.joyagold.data.model.Material;
import com.icfes.joyagold.service.DomainService;

@RestController
public class DomainControllerImpl  implements DomainController{

    @Autowired
    private DomainService domainService;

    @Override
    public List<Material> getMaterials() {
        return this.domainService.getAllMaterials();
    }

}
