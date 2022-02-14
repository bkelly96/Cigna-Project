package com.Team5.HotelReservation.Service;

import com.Team5.HotelReservation.model.Experience;
import com.Team5.HotelReservation.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class ExperienceRequestService {

    List<String> locations = new ArrayList<>();

    @Autowired
    private final ExperienceRepository experienceRepository;


    public ExperienceRequestService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public ExperienceRequestService() {

        experienceRepository = null;
    }

    //Lists for Cigna
    public List<String> listFilter(){

        locations.add("baltimore");
        locations.add("baltimore");
        locations.add("chicago");

        for(int i = 0; i < locations.size(); i++){

            if(locations.get(i) != ("baltimore")){
                locations.remove(i);
            }

        }

        return locations;
    }


    public Experience getExperienceById(long expId){
        return experienceRepository.findById(expId).orElse(null);
    }

//    public Experience getExperienceByHotelId(long hotelId) {
//        return experienceRepository.findByHotelId(hotelId).orElseThrow(() -> new RequestNotFoundException("No Request found with is + " + hotelId));
//    }
}
