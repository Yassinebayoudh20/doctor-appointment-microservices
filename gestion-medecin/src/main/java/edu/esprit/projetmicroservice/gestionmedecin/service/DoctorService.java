package edu.esprit.projetmicroservice.gestionmedecin.service;

import edu.esprit.projetmicroservice.gestionmedecin.IService.IDoctorService;
import edu.esprit.projetmicroservice.gestionmedecin.model.Doctor;
import edu.esprit.projetmicroservice.gestionmedecin.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors;
    }

    @Override
    public long addNewDoctor(Doctor doctor) {
        if(doctor == null) return 0;
        Doctor _doctor = doctorRepository.save(doctor);
        return _doctor.getId();
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        if (doctor.getId() == 0) return null;
        Optional<Doctor> doctorData = doctorRepository.findById(doctor.getId());
        if(doctorData.isPresent()){
            doctorRepository.save(doctor);
            return doctor;
        }
        return null;
    }

    @Override
    public Doctor findDoctorById(long id) {
        Doctor doctor = doctorRepository.findById(id).get();
        if(doctor == null) return null;
        return doctor;
    }

    @Override
    public long deleteDoctorById(long id) {
        if(id == 0) return 0;
        Optional<Doctor> doctorData = doctorRepository.findById(id);
        if(doctorData.isPresent()){
            doctorRepository.deleteById(id);
            return doctorData.get().getId();
        }
        return 0;
    }
}
