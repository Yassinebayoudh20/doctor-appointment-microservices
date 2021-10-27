package edu.esprit.projetmicroservice.gestionordonnance.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.esprit.projetmicroservice.gestionordonnance.model.Medicament;





@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
}