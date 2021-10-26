package edu.esprit.projetmicroservice.userauthservice.service;

import edu.esprit.projetmicroservice.userauthservice.model.Appointement;
import edu.esprit.projetmicroservice.userauthservice.model.ERole;
import edu.esprit.projetmicroservice.userauthservice.model.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface UserService {
    public Boolean updateUser(long id , User user);
    public Boolean deleteUser(long id);
    public List<User> getAllUsers();
    public User findUserById(long id);
    public int addPatientApointement(long idPatient , long idDoctor , Date appointementDate);
    public List<User> getUsersByRole(ERole role);
}
