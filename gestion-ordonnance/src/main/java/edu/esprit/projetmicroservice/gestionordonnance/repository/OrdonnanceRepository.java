package edu.esprit.projetmicroservice.gestionordonnance.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.esprit.projetmicroservice.gestionordonnance.model.Ordonnance;





@Repository
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long> {

}
