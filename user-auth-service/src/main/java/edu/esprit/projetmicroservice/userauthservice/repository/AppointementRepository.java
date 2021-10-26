package edu.esprit.projetmicroservice.userauthservice.repository;

import edu.esprit.projetmicroservice.userauthservice.model.Appointement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AppointementRepository extends JpaRepository<Appointement,Long> {

@Modifying
@Query(value ="INSERT into appointements (patient_id,doctor_id,appointement_date)" +
              "values (:patientID,:doctorID,:appointementDate)"
              ,nativeQuery = true )
public void saveNewPatientAppointement(@Param("patientID") long patientID ,
                                      @Param("doctorID")long doctorID ,
                                      @Param("appointementDate") Date appointementDate);
}

