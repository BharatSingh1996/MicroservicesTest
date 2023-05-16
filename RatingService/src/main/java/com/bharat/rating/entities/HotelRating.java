package com.bharat.rating.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class HotelRating {

	@Id
	private String ratingid;
	
	private String userid;
	private String hotelid;
	private int rating;
	private String feedback;
	
	
}
