package com.app.RentARide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.RentARide.global.GlobalData;
import com.app.RentARide.service.SegmentService;
import com.app.RentARide.service.VehicleService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	SegmentService segmentService;

	@Autowired
	VehicleService vehicleService;

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "index";
	}

	@GetMapping("/garrage")
	public String garrage(Model model) {
		model.addAttribute("categories", segmentService.getAllCategory());
		model.addAttribute("products", vehicleService.getAllProduct());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "garrage";
	}

	@GetMapping("/garrage/category/{id}")
	public String garrageByCategory(Model model, @PathVariable int id) {
		model.addAttribute("categories", segmentService.getAllCategory());
		model.addAttribute("products", vehicleService.getAllProductsByCategoryById(id));
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "garrage";
	}

	@GetMapping("/garrage/viewproduct/{id}")
	public String viewProduct(Model model, @PathVariable int id) {
		model.addAttribute("product", vehicleService.getProductById(id).get());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "viewvehicle";
	}

}
