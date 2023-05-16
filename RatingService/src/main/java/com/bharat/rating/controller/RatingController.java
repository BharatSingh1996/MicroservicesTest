package com.bharat.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharat.rating.entities.HotelRating;
import com.bharat.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<HotelRating> Create(@RequestBody HotelRating hotelRating) {

		return new ResponseEntity<HotelRating>(ratingService.Create(hotelRating), HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<HotelRating>> getAll() {

		List<HotelRating> allHotel = ratingService.FindAllHotel();

		return new ResponseEntity<List<HotelRating>>(allHotel, HttpStatus.OK);
	}

	@GetMapping("user/{userid}")
	public List<HotelRating> ByUserid(@PathVariable("userid") String id) {
		List<HotelRating> findByUserId = ratingService.FindByUserId(id);

		return findByUserId;

	}

	@GetMapping("hotel/{hotelid}")
	public ResponseEntity<List<HotelRating>> ByHotelid(@PathVariable("hotelid") String hid) {
		List<HotelRating> findByHotelId = ratingService.FindByHotelId(hid);

		return new ResponseEntity<List<HotelRating>>(findByHotelId, HttpStatus.OK);

	}

}
