package edu.esprit.projetmicroservice.appointementservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;

    private String password;

    private String email;

    private Set<String> role;

    private String firstName;

    private String lastname;

    private String address;

    private String phone;

    private String about;
}
