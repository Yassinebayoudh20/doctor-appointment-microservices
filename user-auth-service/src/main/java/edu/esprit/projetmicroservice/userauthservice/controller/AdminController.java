package edu.esprit.projetmicroservice.userauthservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.esprit.projetmicroservice.userauthservice.model.Appointement;
import edu.esprit.projetmicroservice.userauthservice.model.User;
import edu.esprit.projetmicroservice.userauthservice.payload.response.MessageResponse;
import edu.esprit.projetmicroservice.userauthservice.service.UserService;
import jdk.nashorn.internal.runtime.JSONFunctions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
@Slf4j
public class AdminController {

    @Autowired
    UserService userService;

    @PutMapping("/users/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUsers(@PathVariable long id ,@RequestBody User user ) {
        try {
            Boolean userToUpdate = userService.updateUser(id,user);
            if(userToUpdate == false) return ResponseEntity.badRequest().build();
            log.info("Object {} modified to {}",user,userToUpdate);
            return ResponseEntity.ok(new MessageResponse("User has been updated successfully"));
        }catch(Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUsers(@PathVariable long id) {
        try {
        Boolean deletedUser = userService.deleteUser(id);
        if(!deletedUser) return ResponseEntity.badRequest().build();
        log.info("Deleting User ...");
        return ResponseEntity.ok(new MessageResponse("User has been deleted successfully"));
        }catch(Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUsersList() {
       try{
            List<User> users = userService.getAllUsers();
            if(users == null) return ResponseEntity.noContent().build();
           log.info("Getting Users List..");
           return ResponseEntity.ok(users);
        }catch(Exception e){
        log.error(e.getMessage());
        return ResponseEntity.internalServerError().build();
    }
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        try{
            User user = userService.findUserById(id);
            if(user == null) return ResponseEntity.notFound().build();
            log.info("Getting User id = {}" ,id);
            return ResponseEntity.ok(user);
        }catch(Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "{idPatient}/doctors/{idDoctor}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<Integer> addPatientAppointement(@PathVariable long idPatient,
                                                    @PathVariable long idDoctor ,
                                                    @RequestBody String appointementDate ) throws Exception {
        int isAdded = userService.addPatientApointement(idPatient,idDoctor,new SimpleDateFormat("dd/MM/yyyy").parse("15/09/2021"));
          log.info("Getting Patient with Id {} appointements {}",idPatient , isAdded);
          return ResponseEntity.ok(isAdded);
    }



}
