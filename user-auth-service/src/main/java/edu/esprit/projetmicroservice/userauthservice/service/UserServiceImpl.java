package edu.esprit.projetmicroservice.userauthservice.service;

import edu.esprit.projetmicroservice.userauthservice.model.Appointement;
import edu.esprit.projetmicroservice.userauthservice.model.ERole;
import edu.esprit.projetmicroservice.userauthservice.model.User;
import edu.esprit.projetmicroservice.userauthservice.repository.AppointementRepository;
import edu.esprit.projetmicroservice.userauthservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppointementService appointementService ;

    @Override
    public Boolean updateUser(long id, User user) {
        if(id <= 0) return false;
        log.info("{}",user);
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User userFromDB = userOptional.get();
            userFromDB.setUsername(user.getUsername());
            userFromDB.setEmail(user.getEmail());
            userRepository.save(userFromDB);
            return true;
        }
        return false;
            }

    @Override
    public Boolean deleteUser(long id) {
        if(id <= 0) return false;
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(!users.isEmpty()){
            return users;
        }else return null;
    }

    @Override
    public User findUserById(long id) {
        if(id <= 0) return null;
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
           return userOptional.get();
        }
        return null;
    }

    @Override
    @Transactional
    public  int addPatientApointement(long idPatient, long idDoctor, Date appointementDate) {
        Optional<User> patientOptional = userRepository.findById(idPatient);
        Optional<User> doctorOptional = userRepository.findById(idDoctor);
        log.info("{} {}", patientOptional.get(), doctorOptional.get());
        if (patientOptional.isPresent() && doctorOptional.isPresent()) {
            User patient = patientOptional.get();
            User doctor = doctorOptional.get();
            appointementService.addAppointement(patient.getId(),doctor.getId(),appointementDate);
            return 1;
        } else return 0;
    }

    @Override
    public List<User> getUsersByRole(ERole role) {
        log.info("role {}",role.name());
            List<User> users = userRepository.findAllByRolename(role.name());
            if(users.isEmpty()) return null;
            return users;
    }
}
