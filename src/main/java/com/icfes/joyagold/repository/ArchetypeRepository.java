package com.icfes.joyagold.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icfes.joyagold.data.model.Archetype;

@Repository
public interface ArchetypeRepository extends JpaRepository<Archetype, Integer> {}
