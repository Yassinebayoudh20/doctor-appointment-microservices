package edu.esprit.projetmicroservice.userauthservice.repository;

import java.util.Optional;

import edu.esprit.projetmicroservice.userauthservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
