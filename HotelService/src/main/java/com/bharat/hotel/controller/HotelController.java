package com.bharat.hotel.controller;

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

import com.bharat.hotel.entitis.Hotel;
import com.bharat.hotel.service.HotelServiceInterface;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelServiceInterface hotelServiceInterface;

	@PostMapping
	public ResponseEntity<Hotel> Create(@RequestBody Hotel hotel) {
		return new ResponseEntity<Hotel>(hotelServiceInterface.Create(hotel), HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<Hotel>> get() {

		return new ResponseEntity<List<Hotel>>(hotelServiceInterface.getallHotel(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public Hotel FindOne(@PathVariable("id") String id) {

		return hotelServiceInterface.FindOne(id);

	}

	@GetMapping("user/{id}")
	public ResponseEntity<Hotel> ByUserId(@PathVariable("id") String id) {

		return new ResponseEntity<Hotel>(hotelServiceInterface.ByUserId(id), HttpStatus.OK);

	}

}
