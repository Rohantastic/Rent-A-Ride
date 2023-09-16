package com.app.RentARide.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.RentARide.dto.VehicleDTO;
import com.app.RentARide.entity.Segment;
import com.app.RentARide.entity.Vehicle;
import com.app.RentARide.service.SegmentService;
import com.app.RentARide.service.VehicleService;

@Controller
public class AdminController {

	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

	@Autowired
	SegmentService segmentService;

	@Autowired
	VehicleService vehicleService;

	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
	}

	@GetMapping("/admin/segments")
	public String getCat(Model model) {
		model.addAttribute("categories", segmentService.getAllCategory());
		return "segments";
	}

	@GetMapping("/admin/segments/add")
	public String getCatAdd(Model model) {
		model.addAttribute("category", new Segment());
		return "segmentsAdd";
	}

	@PostMapping("/admin/segments/add")
	public String postCatAdd(@ModelAttribute("category") Segment segment) {
		segmentService.addCatrgory(segment);
		return "redirect:/admin/segments";
	}

	@GetMapping("/admin/segments/delete/{id}")
	public String deleteCat(@PathVariable int id) {
		segmentService.removeCategoryById(id);
		return "redirect:/admin/segments";
	}

	@GetMapping("/admin/segments/update/{id}")
	public String updateCat(@PathVariable int id, Model model) {
		Optional<Segment> segment = segmentService.getCategoryById(id);
		if (segment.isPresent()) {
			model.addAttribute("category", segment.get());
			return "segmentsAdd";
		} else {
			return "404";
		}
	}

	// Product Section
	@GetMapping("/admin/vehicles")
	public String products(Model model) {
		model.addAttribute("products", vehicleService.getAllProduct());
		return "vehicles";
	}

	@GetMapping("/admin/vehicles/add")
	public String productAddGet(Model model) {
		model.addAttribute("productDTO", new VehicleDTO());
		model.addAttribute("categories", segmentService.getAllCategory());
		return "vehicleAdd";
	}

	@PostMapping("/admin/vehicles/add")
	public String productAddPost(@ModelAttribute("productDTO") VehicleDTO vehicleDTO,
			@RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgName)
			throws IOException {

		Vehicle vehicle = new Vehicle();

		vehicle.setId(vehicleDTO.getId());
		vehicle.setName(vehicleDTO.getName());
		vehicle.setCategory(segmentService.getCategoryById(vehicleDTO.getCategoryId()).get());
		vehicle.setPrice(vehicleDTO.getPrice());
		vehicle.setAverage(vehicleDTO.getAverage());
		vehicle.setVariant(vehicleDTO.getVariant());
		vehicle.setDescription(vehicleDTO.getDescription());

		String imageUUID;
		if (!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNamePath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNamePath, file.getBytes());
		} else {
			imageUUID = imgName;

		}
		vehicle.setImageName(imageUUID);
		vehicleService.addProduct(vehicle);

		return "redirect:/admin/vehicles";
	}

	@GetMapping("/admin/vehicle/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		vehicleService.removeProductById(id);
		return "redirect:/admin/vehicles";
	}

	@GetMapping("/admin/vehicle/update/{id}")
	public String updateProductGet(@PathVariable long id, Model model) {
		Vehicle vehicle = vehicleService.getProductById(id).get();
		VehicleDTO vehicleDTO = new VehicleDTO();

		vehicleDTO.setId(vehicle.getId());
		vehicleDTO.setName(vehicle.getName());
		vehicleDTO.setCategoryId(vehicle.getCategory().getId());
		vehicleDTO.setPrice(vehicle.getPrice());
		vehicleDTO.setAverage(vehicle.getAverage());
		vehicleDTO.setVariant(vehicle.getVariant());
		vehicleDTO.setDescription(vehicle.getDescription());
		vehicleDTO.setImageName(vehicle.getImageName());

		model.addAttribute("categories", segmentService.getAllCategory());
		model.addAttribute("productDTO", vehicleDTO);

		return "vehicleAdd";
	}

}
