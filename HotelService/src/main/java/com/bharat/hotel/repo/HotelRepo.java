package com.bharat.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharat.hotel.entitis.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String> {

	Hotel findByUserid(String id);
}
