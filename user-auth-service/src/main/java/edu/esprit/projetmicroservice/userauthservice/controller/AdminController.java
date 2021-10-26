package edu.esprit.projetmicroservice.userauthservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.esprit.projetmicroservice.userauthservice.model.Appointement;
import edu.esprit.projetmicroservice.userauthservice.model.AppointementVO;
import edu.esprit.projetmicroservice.userauthservice.model.Role;
import edu.esprit.projetmicroservice.userauthservice.model.User;
import edu.esprit.projetmicroservice.userauthservice.payload.response.MessageResponse;
import edu.esprit.projetmicroservice.userauthservice.service.UserService;
import jdk.nashorn.internal.runtime.JSONFunctions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/users/{id}")
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



    @PostMapping(value = "{idPatient}/doctors/{idDoctor}")
    @PreAuthorize("hasRole('ROLE_PATIENT') or hasRole('ADMIN')")
    public AppointementVO addPatientAppointement(@PathVariable long idPatient,
                                                    @PathVariable long idDoctor ,
                                                    @RequestParam String appointementDate ) throws Exception {
       String url = "http://localhost:9003/api/appointement/";
       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);
       AppointementVO appointementVO = new AppointementVO(new SimpleDateFormat("yyyy-MM-dd").parse(appointementDate),idPatient,idDoctor);
       HttpEntity<AppointementVO> request = new HttpEntity<>(appointementVO,headers);
       ResponseEntity<AppointementVO> result = restTemplate.postForEntity(url,request,AppointementVO.class);
       if(result.getStatusCode() == HttpStatus.CREATED ){
            return result.getBody();
        }else return null;
    }

    @GetMapping("usersByRole")
    @ResponseBody
    public ResponseEntity<?> findUsersByRole(@RequestBody Role role){
            //if(role.isEmpty()) return ResponseEntity.badRequest().build();
            List<User> users = userService.getUsersByRole(role.getName());
            if(users == null) return ResponseEntity.noContent().build();
            return ResponseEntity.ok(users);
    }



}
