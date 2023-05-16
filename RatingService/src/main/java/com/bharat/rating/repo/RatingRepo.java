package com.bharat.rating.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharat.rating.entities.HotelRating;

public interface RatingRepo extends JpaRepository<HotelRating, String> {

	 List<HotelRating> findByUserid(String id);//findBy(Column_name) 
	 List<HotelRating> findByHotelid(String id);
	
	
}
