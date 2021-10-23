package edu.esprit.projetmicroservice.userauthservice.service;

import edu.esprit.projetmicroservice.userauthservice.model.Appointement;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface AppointementService {
    public void addAppointement(long patientID, long doctorID , Date appointementDate);
}
