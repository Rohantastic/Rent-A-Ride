package com.app.RentARide.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.RentARide.entity.Role;
import com.app.RentARide.entity.User;
import com.app.RentARide.global.GlobalData;
import com.app.RentARide.repository.RoleRepository;
import com.app.RentARide.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@GetMapping("/login")
	public String login() {
		GlobalData.cart.clear();
		return "login";
	}

	@GetMapping("/register")
	public String registerGet(User user) {
		return "register";
	}

	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute("user") User user, Errors errors, HttpServletRequest request,
			Model model) throws ServletException {

		if (errors.hasErrors()) {
			return "register";
		} else {
			model.addAttribute("message", "Registration successfully...");
			String password = user.getPassword();
			user.setPassword(bCryptPasswordEncoder.encode(password));
			List<Role> roles = new ArrayList<>();
			roles.add(roleRepository.findById(2).get());
			user.setRoles(roles);
			userRepository.save(user);
			request.login(user.getEmail(), password);
			return "redirect:/garrage";
		}
	}

}
