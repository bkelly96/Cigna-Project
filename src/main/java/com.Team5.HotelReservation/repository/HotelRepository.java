package com.Team5.HotelReservation.repository;

import com.Team5.HotelReservation.model.Hotel;
import com.Team5.HotelReservation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("hotelRepo")
public interface HotelRepository extends JpaRepository<Hotel, Long>{
}
