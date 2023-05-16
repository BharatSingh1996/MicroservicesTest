package com.bharat.user.service.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharat.user.service.entities.Hotel;
import com.bharat.user.service.entities.HotelRating;
import com.bharat.user.service.entities.User;
import com.bharat.user.service.exceptions.NoResourceFoundException;
import com.bharat.user.service.repo.UserRepo;
import com.bharat.user.service.service.feignInterfc.FeignRating;
import com.bharat.user.service.service.feignInterfc.FeingHotelProxy;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private FeignRating feignRating;
	@Autowired
	private FeingHotelProxy proxy;

	@Override
	public User SaveUser(User user) {

		String string = UUID.randomUUID().toString();
		user.setUserid(string);
		User user2 = userRepo.save(user);
		return user2;
	}

	@Override
	public List<User> GetAllUser() {

		return userRepo.findAll();
	}

	@Override
	public User FindById(String userID) {

		User user = userRepo.findById(userID)
				.orElseThrow(() -> new NoResourceFoundException("Resource not found" + userID));

		List<HotelRating> ratings = feignRating.ByUserid(userID);

		List<HotelRating> collect = ratings.stream().map(e -> {
			Hotel hotel = proxy.getHotel(e.getHotelid());
			e.setHotel(hotel);
			return e;

		}).collect(Collectors.toList());

		user.setRating(collect);
		return user;
	}

	@Override
	public void DeleteById(String id) {

		userRepo.deleteById(id);
	}

	@Override
	public User Update(User user) {
		User saved = userRepo.save(user);
		return saved;
	}

}
