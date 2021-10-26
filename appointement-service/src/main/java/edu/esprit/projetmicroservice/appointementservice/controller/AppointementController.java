package edu.esprit.projetmicroservice.appointementservice.controller;

import edu.esprit.projetmicroservice.appointementservice.model.Appointement;
import edu.esprit.projetmicroservice.appointementservice.model.User;
import edu.esprit.projetmicroservice.appointementservice.service.AppointementService;
import edu.esprit.projetmicroservice.appointementservice.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/appointement")
public class AppointementController {

    @Autowired
    private AppointementService appointementService;

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<Appointement> addNewAppointement(@RequestBody Appointement appointement){
    if(appointement.getIdDoctor() <=0 || appointement.getIdPatient() <=0 ) return ResponseEntity.badRequest().build();
    long result = appointementService.addNewAppointement(appointement);
    if(result > 0 ) return ResponseEntity.status(HttpStatus.CREATED).body(appointement);
    return ResponseEntity.internalServerError().build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> changeAppointementDate(@PathVariable Long id,@RequestParam(value = "date") String date) throws ParseException {
        if(id <= 0) return ResponseEntity.badRequest().build();
        Date appointementDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Long result = appointementService.changeAppointementDate(id,appointementDate);
        if(result == 0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new ResponseMessage("Appointement Modified"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> canclePatientAppointement(@PathVariable Long id){
        if(id <= 0) return ResponseEntity.badRequest().build();
        Long result = appointementService.cancleAppointement(id);
        if(result ==0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new ResponseMessage("Appointement Deleted"));
    }

    @GetMapping("/doctor/{idDoctor}")
    public ResponseEntity<?> getDoctorAppointement(@PathVariable Long idDoctor){
        if(idDoctor <= 0) return ResponseEntity.badRequest().build();
        List<Map<String,Object>> appointementList = appointementService.getDoctorAppointements(idDoctor);
        if(appointementList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(appointementList);
    }
}
