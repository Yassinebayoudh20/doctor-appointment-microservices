package edu.esprit.projetmicroservice.userauthservice.service;

import edu.esprit.projetmicroservice.userauthservice.model.Appointement;
import edu.esprit.projetmicroservice.userauthservice.repository.AppointementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppointementServiceImpl implements AppointementService {

    @Autowired
    AppointementRepository appointementRepository;

    @Override
    public void addAppointement(long patientID, long doctorID , Date appointementDate) {
        appointementRepository.saveNewPatientAppointement(patientID,doctorID,appointementDate);
    }
}
