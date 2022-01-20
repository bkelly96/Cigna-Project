package com.Team5.HotelReservation.configuration;


import com.Team5.HotelReservation.Service.*;
import com.Team5.HotelReservation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.PreUpdate;

@Configuration
@ComponentScan("com.Team5.HotelReservation.repository")
public class ServiceConfiguration {

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    TripRepository tripRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelPaginatedRepository paginatedRepository;

    @Autowired
    UserPaginatedRepository userPaginatedRepository;


    @Bean
    @Primary
    @Qualifier("expRepo")
    public ExperienceRequestService expService(){
        return new ExperienceRequestService(experienceRepository);
    }

    @Bean
    @Primary
    @Qualifier("hotelRepo")
    public HotelRequestServiceImplementation hotelService(){
        return new HotelRequestServiceImplementation(hotelRepository, paginatedRepository);
    }

    @Bean
    @Primary
    @Qualifier("tripRepo")
    public TripRequestService tripService(){
        return new TripRequestService(tripRepository);
    }

    @Bean
    @Primary
    @Qualifier("userRepo")
    public UserRequestServiceImplementation userService(){
        return new UserRequestServiceImplementation(userRepository, userPaginatedRepository);
    }

}
