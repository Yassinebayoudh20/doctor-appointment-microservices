package edu.esprit.projetmicroservice.appointementservice.service;

import edu.esprit.projetmicroservice.appointementservice.model.Appointement;
import edu.esprit.projetmicroservice.appointementservice.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AppointementService {
    public Long addNewAppointement(Appointement appointement);
    public Long changeAppointementDate(Long id , Date appointementDate);
    public Long cancleAppointement(Long id);
    public List<Map<String,Object>> getDoctorAppointements(Long doctorId);

}
