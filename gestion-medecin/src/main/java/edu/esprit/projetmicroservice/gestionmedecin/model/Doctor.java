package edu.esprit.projetmicroservice.gestionmedecin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Doctor")
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String lastName;

    private Date birthday;

    private String phoneNumber;

    private String specialty;

    private String sex;

    /*@OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Appointement> patients = new ArrayList<>();*/

    private String email;

    private String password;


}
