package edu.esprit.projetmicroservice.appointementservice.repository;

import edu.esprit.projetmicroservice.appointementservice.model.Appointement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointementRepository extends JpaRepository<Appointement,Long> {
}
