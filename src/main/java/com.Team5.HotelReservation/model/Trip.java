package com.Team5.HotelReservation.model;


import com.Team5.HotelReservation.Service.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Trip")
@Data
@NoArgsConstructor

public class Trip {


    @Id //Primary Key for Unique Users
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    private String checkIn;
    private String checkOut;
    @Enumerated(EnumType.STRING)
    private Room room = Room.Single;
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expId")
    private Experience expId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "hotelId")
    private Hotel hotelId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User userId;

    public Trip(Long tripId, String checkIn, String checkOut, Room room, String location, Experience expId, Hotel hotelId, User userId) {
        this.tripId = tripId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
        this.location = location;
        this.expId = expId;
        this.hotelId = hotelId;
        this.userId = userId;
    }
}
