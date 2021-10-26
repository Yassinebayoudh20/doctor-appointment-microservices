package edu.esprit.projetmicroservice.userauthservice.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import edu.esprit.projetmicroservice.userauthservice.model.ERole;
import edu.esprit.projetmicroservice.userauthservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    @Query("select u from User u join Role r where r.name = :roleName")
    List<User> findAllByRolename(@Param("roleName") String roleName);

}
