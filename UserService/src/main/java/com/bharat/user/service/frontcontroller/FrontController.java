package com.bharat.user.service.frontcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bharat.user.service.entities.User;
import com.bharat.user.service.service.UserService;

@Controller
@RequestMapping("/front")
public class FrontController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String GetAllUser(Model model) {

		List<User> getAllUser = userService.GetAllUser();

		model.addAttribute("user", getAllUser);

		return "Welcome";

	}

}
