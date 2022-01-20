package com.Team5.HotelReservation.Service;

import com.Team5.HotelReservation.model.Experience;
import com.Team5.HotelReservation.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceRequestService {

    @Autowired
    private final ExperienceRepository experienceRepository;


    public ExperienceRequestService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }


    public Experience getExperienceById(long expId){
        return experienceRepository.findById(expId).orElse(null);
    }

//    public Experience getExperienceByHotelId(long hotelId) {
//        return experienceRepository.findByHotelId(hotelId).orElseThrow(() -> new RequestNotFoundException("No Request found with is + " + hotelId));
//    }
}
