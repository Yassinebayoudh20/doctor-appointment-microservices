package edu.esprit.projetmicroservice.userauthservice.repository;

import java.util.Optional;

import edu.esprit.projetmicroservice.userauthservice.model.ERole;
import edu.esprit.projetmicroservice.userauthservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
