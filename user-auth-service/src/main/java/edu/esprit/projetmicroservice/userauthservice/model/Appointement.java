package edu.esprit.projetmicroservice.userauthservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointements")
public class Appointement  {

      @EmbeddedId
      private DoctorPatientId id;

      @ManyToOne(fetch = FetchType.LAZY)
      @MapsId("DoctorId")
      private User doctor;

      @ManyToOne(fetch = FetchType.LAZY)
      @MapsId("PatientId")
      private User patient;

      @Column(name = "appointement_date")
      @JsonFormat(pattern = "yyyy-MM-dd")
      private String appointementDate;

      @Column(name = "created_on")
      private Date createdOn = new Date();

      public Appointement(User doctor, User patient, String appointementDate) {
            this.doctor = doctor;
            this.patient = patient;
            this.appointementDate = appointementDate;
      }
}
