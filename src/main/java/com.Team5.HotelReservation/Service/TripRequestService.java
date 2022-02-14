package com.Team5.HotelReservation.Service;

import com.Team5.HotelReservation.model.Trip;
import com.Team5.HotelReservation.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class TripRequestService {

    List<String> tripList = new ArrayList<>();

    @Autowired
    private final TripRepository tripRepository;
    
    public TripRequestService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public TripRequestService() {

        tripRepository = null;
    }

    //returning null
    public List<String> getFixedList(){

        for(long i = 1; i < tripRepository.count(); i++ )

            if(tripRepository.getById(i).getRoom() == Room.Double){
                tripList.add(String.valueOf(tripRepository.getById(i).getRoom()));
            }

        return tripList;
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
