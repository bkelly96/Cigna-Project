//package com.Team5.HotelReservation.configuration;
//
//
//import com.Team5.HotelReservation.Service.*;
//import com.Team5.HotelReservation.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ServiceConfiguration {
//
//    @Autowired
//    ExperienceRepository experienceRepository;

//    @Autowired
//    TripRepository tripRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    HotelRepository hotelRepository;
//
//    @Autowired
//    HotelPaginatedRepository paginatedRepository;
//
//    @Autowired
//    UserPaginatedRepository userPaginatedRepository;

//    @Bean
//    public ExperienceRequestService expService(){
//        return new ExperienceRequestService(experienceRepository);
//    }
//
//
////
////    @Bean
////    public HotelRequestServiceImplementation hotelService(){
////        return new HotelRequestServiceImplementation(hotelRepository, paginatedRepository);
////    }
////
////    @Bean
////    public TripRequestService tripService(){
////        return new TripRequestService(tripRepository);
////    }
//
////    @Bean
////    public UserRequestServiceImplementation userService(){
////        return new UserRequestServiceImplementation(userRepository, userPaginatedRepository);
////    }
//
//}
