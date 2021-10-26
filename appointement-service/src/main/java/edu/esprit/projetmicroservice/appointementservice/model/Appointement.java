package edu.esprit.projetmicroservice.appointementservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "appointement_date")
    private Date appointementDate;

    @Column(name = "id_patient")
    private Long idPatient;

    @Column(name = "id_doctor")
    private Long idDoctor;

}
