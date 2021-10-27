package com.esprit.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.microservice.model.Suivi;

@Repository
public interface SuiviRepository extends JpaRepository <Suivi, Long>  {

}
