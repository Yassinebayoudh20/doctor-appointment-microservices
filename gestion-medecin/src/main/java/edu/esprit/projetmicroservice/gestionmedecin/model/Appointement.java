package edu.esprit.projetmicroservice.gestionmedecin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Appointement")
@Table(name = "appointements")
public class Appointement  {

      @EmbeddedId
      private DoctorPatientId id;

      @ManyToOne(fetch = FetchType.LAZY)
      @MapsId("DoctorId")
      private Doctor doctor;

      @ManyToOne(fetch = FetchType.LAZY)
      @MapsId("PatientId")
      private Patient patient;

      @Column(name = "appointement_date")
      private Date appointementDate;

      @Column(name = "created_on")
      private Date createdOn = new Date();

}
