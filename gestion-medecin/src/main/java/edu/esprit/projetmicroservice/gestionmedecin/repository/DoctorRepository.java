package edu.esprit.projetmicroservice.gestionmedecin.repository;

import edu.esprit.projetmicroservice.gestionmedecin.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor,Long> {
}
