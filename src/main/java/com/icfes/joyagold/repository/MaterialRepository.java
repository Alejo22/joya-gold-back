package com.icfes.joyagold.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icfes.joyagold.data.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
