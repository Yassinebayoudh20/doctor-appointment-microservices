package edu.esprit.projetmicroservice.userauthservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPatientId implements Serializable {

    @Column(name = "doctor_id")
    private long DoctorId;

    @Column(name = "patient_id")
    private long PatientId;
}
