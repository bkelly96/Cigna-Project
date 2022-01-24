package com.Team5.HotelReservation.Service;

import com.Team5.HotelReservation.model.Trip;
import com.Team5.HotelReservation.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class TripRequestService {

    @Autowired
    private final TripRepository tripRepository;

    public TripRequestService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip getTripById(long tripId) {
        return tripRepository.findById(tripId).orElse(null);
    }


    public void createTrip(Trip trip){
        tripRepository.save(trip);
    }

    public void setRoom(long id, Room room){
        tripRepository.findById(id).map(trip -> {
            trip.setRoom(room);
            return tripRepository.save(trip);
        }).orElse(null);
    }

    public void deleteTrip(long id) {
        tripRepository.deleteById(id);
    }
}
