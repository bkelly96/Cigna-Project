package com.Team5.HotelReservation.model;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "User")
@Data
public class User {

    @Id //Primary Key for Unique Users
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "{username.notempty}")
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

    public User(Long id, String username, String password, String fName, String lName, String email, String role, boolean isEnabled, List<Experience> expId, List<Trip> tripId) {
        Id = id;
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.role = role;
        this.isEnabled = isEnabled;
        this.expId = expId;
        this.tripId = tripId;
    }

    public User() {
    }
}
