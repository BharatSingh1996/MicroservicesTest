package com.bharat.user.service.service.feignInterfc;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bharat.user.service.entities.HotelRating;

@FeignClient("RATINGSERVICE")
public interface FeignRating {

	@GetMapping("ratings/user/{userid}")
	public List<HotelRating> ByUserid(@PathVariable("userid") String id);
}
