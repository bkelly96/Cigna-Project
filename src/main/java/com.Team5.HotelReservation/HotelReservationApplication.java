package com.Team5.HotelReservation;

import com.Team5.HotelReservation.Service.ExperienceRequestService;
import com.Team5.HotelReservation.Service.TripRequestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HotelReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationApplication.class, args);

//		ExperienceRequestService listTest = new ExperienceRequestService();
//
//		System.out.println(Arrays.toString(listTest.listFilter().toArray()));

		TripRequestService fixedList = new TripRequestService();

		System.out.println(Arrays.toString(fixedList.getFixedList().toArray()));

	}

}
