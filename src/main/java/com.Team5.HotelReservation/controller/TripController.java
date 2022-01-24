package com.Team5.HotelReservation.controller;


import com.Team5.HotelReservation.Service.Room;
import com.Team5.HotelReservation.Service.TripRequestService;
import com.Team5.HotelReservation.exception.TripNotFoundException;
import com.Team5.HotelReservation.model.Trip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/trip")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TripController {


    private final TripRequestService tripRequestService;

    public TripController(TripRequestService tripRequestService) {
        this.tripRequestService = tripRequestService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Trip> getAllTrips(@PathVariable long id){
        Trip trip = tripRequestService.getTripById(id);
        if(trip == null){
            throw new TripNotFoundException("Trip Not Found");
        }
        return new ResponseEntity<Trip>(trip,OK);
    }

    @PostMapping
    public ResponseEntity createTrip(@RequestBody Trip trip){
        tripRequestService.createTrip(trip);
        return new ResponseEntity(CREATED);
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity updateTrip(@PathVariable long id, @PathVariable Room room){
        tripRequestService.setRoom(id, room);
        return new ResponseEntity(OK);
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteTrip(@PathVariable long id){
        tripRequestService.deleteTrip(id);
    }




}
