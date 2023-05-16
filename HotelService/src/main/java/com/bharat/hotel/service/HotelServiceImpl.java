package com.bharat.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharat.hotel.entitis.Hotel;
import com.bharat.hotel.exception.ResourceNotFound;
import com.bharat.hotel.repo.HotelRepo;

@Service
public class HotelServiceImpl implements HotelServiceInterface {

	@Autowired
	//@Qualifier("HotelRepo") // if i had two HotelRepo then it would happend ambiguity problem,that which
							// bean it will take to create object
	HotelRepo hotelRepo;

	@Override
	public Hotel Create(Hotel hotel) {
		String str = UUID.randomUUID().toString();

		hotel.setHotelid(str);
		Hotel save = hotelRepo.save(hotel);
		return save;
	}

	

	@Override
	public Hotel FindOne(String id) {

		return hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Resource Not Found " + id));
	}

	@Override
	public List<Hotel> getallHotel() {

		List<Hotel> all = hotelRepo.findAll();
		return all;
	}



	@Override
	public Hotel ByUserId(String id) {

		return hotelRepo.findByUserid(id);
	}





}
