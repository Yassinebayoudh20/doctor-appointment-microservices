package edu.esprit.projetmicroservice.gestionmedecin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String Name;

    private String LastName;

    private Date Birthday;

    private String PhoneNumber;

    private String Sex;

    private String Email;

    private String Password;


}
