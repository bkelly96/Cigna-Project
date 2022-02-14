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

/*
 Constraint Violation Exceptions Customer Response
 Create YML file and create a message (Please provide valid user name, password, username empty,
 //Store it and pull it from property) Each constraint should be in the property file
 */

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
    public ExperienceRequestService experienceRequestService(){
        return new ExperienceRequestService(experienceRepository);
    }

    @Bean
    public HotelRequestServiceImplementation hotelRequestServiceImplementation(){
        return new HotelRequestServiceImplementation(hotelRepository, paginatedRepository);
    }

    @Bean
    public TripRequestService tripRequestService(){
        return new TripRequestService(tripRepository);
    }

    @Bean
    public UserRequestServiceImplementation userService(){
        return new UserRequestServiceImplementation(userRepository, userPaginatedRepository);
    }

}
