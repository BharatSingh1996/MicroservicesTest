package com.bharat.hotel.service;

import java.util.List;

import com.bharat.hotel.entitis.Hotel;

public interface HotelServiceInterface {

	public Hotel Create(Hotel hotel);
	
	public List<Hotel> getallHotel();
	
	public Hotel FindOne(String id);

	public Hotel ByUserId(String id);

	

	
}
