package edu.esprit.projetmicroservice.gestionmedecin.IService;

import edu.esprit.projetmicroservice.gestionmedecin.entity.Doctor;

import java.util.List;

public interface IDoctorService {

    public List<Doctor> findAllDoctors();
    public long addNewDoctor(Doctor doctor);
    public Doctor updateDoctor(Doctor doctor);
    public Doctor findDoctorById(long id);
    public long deleteDoctorById(long id);
}
