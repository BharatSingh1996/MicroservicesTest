package com.bharat.rating.service;

import java.util.List;

import com.bharat.rating.entities.HotelRating;

public interface RatingService {

	public HotelRating Create(HotelRating hotelRating);
	
	public List<HotelRating> FindAllHotel();
	
	public  List<HotelRating> FindByUserId(String id);
	
	public List<HotelRating> FindByHotelId(String id);
	
	
}
