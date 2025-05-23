package com.example.evsimulator.repository;

import com.example.evsimulator.model.Charger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargerRepository extends JpaRepository<Charger, String> {
}