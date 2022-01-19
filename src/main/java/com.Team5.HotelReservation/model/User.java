package com.Team5.HotelReservation.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id //Primary Key for Unique Users
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]+$")
    private String username;

    @NotNull
    @Pattern(regexp = "^[A-Za-z]+$")
    private String password;

    @Pattern(regexp = "^[A-Za-z]+$")
    private String fName;

    @Pattern(regexp = "^[A-Za-z]+$")
    private String lName;

    @NotNull
    @Email
    private String email;

    private String role;
    private boolean isEnabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expId")
    private List<Experience> expId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Trip> tripId;

}
