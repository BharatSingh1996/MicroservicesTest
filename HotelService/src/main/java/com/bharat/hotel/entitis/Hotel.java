package com.bharat.hotel.entitis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="hotel_table")
public class Hotel {

	@Id
	@Column(name="ID")
	private String hotelid;
	private String name;
	private String  location;
	private String about;
	private String userid;
	
	
	
}
