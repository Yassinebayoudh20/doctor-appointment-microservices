package edu.esprit.projetmicroservice.userauthservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointementVO {

    private Date appointementDate;
    private Long idPatient;
    private Long idDoctor;

}
