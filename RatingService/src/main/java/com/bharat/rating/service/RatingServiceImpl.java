package com.bharat.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharat.rating.entities.HotelRating;
import com.bharat.rating.repo.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepo ratingRepo;
	

	@Override
	public HotelRating Create(HotelRating hotelRating) {

		String string = UUID.randomUUID().toString();
		hotelRating.setRatingid(string);

		HotelRating saved = ratingRepo.save(hotelRating);

		return saved;
	}

	@Override
	public List<HotelRating> FindAllHotel() {

		return ratingRepo.findAll();
	}

	@Override
	public List<HotelRating> FindByUserId(String id) {

		List<HotelRating> ratinglist = ratingRepo.findByUserid(id);

	
		return ratinglist;

	}

	@Override
	public List<HotelRating> FindByHotelId(String id) {

		return ratingRepo.findByHotelid(id);
	}

}
