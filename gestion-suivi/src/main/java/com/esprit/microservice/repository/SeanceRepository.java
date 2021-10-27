package com.esprit.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.microservice.model.Seance;

@Repository
public interface SeanceRepository extends JpaRepository <Seance,Long> {

}
