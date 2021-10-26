package edu.esprit.projetmicroservice.appointementservice.service;

import edu.esprit.projetmicroservice.appointementservice.model.Appointement;
import edu.esprit.projetmicroservice.appointementservice.model.User;
import edu.esprit.projetmicroservice.appointementservice.repository.AppointementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointementServiceImpl implements AppointementService{

    @Autowired
    AppointementRepository appointementRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Long addNewAppointement(Appointement appointement) {
        return appointementRepository.save(appointement).getId();
    }

    @Override
    public Long changeAppointementDate(Long id, Date appointementDate) {
        if(id <= 0) return 0L;
        Optional<Appointement> appointementOptional = appointementRepository.findById(id);
        if(appointementOptional.isPresent()){
            Appointement appointement = appointementOptional.get();
            appointement.setAppointementDate(appointementDate);
            appointementRepository.save(appointement);
            return 1L;
        }else return 0L;

    }

    @Override
    public Long cancleAppointement(Long id) {
        if(id <= 0) return 0L;
        Optional<Appointement> appointementOptional = appointementRepository.findById(id);
        if(appointementOptional.isPresent()){
            Appointement appointement = appointementOptional.get();
            appointementRepository.deleteById(id);
            return 1L;
        }else return 0L;
    }

    @Override
    public List<Map<String,Object>> getDoctorAppointements(Long doctorId) {
        if(doctorId <= 0) return null;
        List<Map<String,Object>> mapList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        List<User> userappointements = new ArrayList<>();
        List<Appointement> appointements = appointementRepository.findAll().stream().filter(appointement -> appointement.getIdDoctor() == doctorId).collect(Collectors.toList());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

         appointements.forEach(appointement -> {
            User user = restTemplate.getForObject("http://localhost:9002/api/auth/users/"+appointement.getIdPatient(),User.class);
            userappointements.add(user);
            map.put("AppointementDate",appointement.getAppointementDate());
            map.put("userInfo",userappointements);
        });
        mapList.add(map);
         return mapList;
    }


}
