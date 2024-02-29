package com.icfes.joyagold.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icfes.joyagold.data.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
