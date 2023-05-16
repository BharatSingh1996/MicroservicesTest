package com.bharat.user.service.service.feignInterfc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bharat.user.service.entities.Hotel;


@FeignClient("HOTELSERVICE")
public interface FeingHotelProxy {

	@GetMapping("/hotels/{id}")
	public  Hotel getHotel(@PathVariable("id") String id);
	
}
