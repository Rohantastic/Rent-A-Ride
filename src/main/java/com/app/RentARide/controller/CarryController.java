package com.app.RentARide.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.RentARide.entity.BillingDetails;
import com.app.RentARide.entity.Vehicle;
import com.app.RentARide.global.GlobalData;
import com.app.RentARide.service.BillDetailsService;
import com.app.RentARide.service.EmailService;
import com.app.RentARide.service.VehicleService;

@Controller
public class CarryController {
	@Autowired
	VehicleService vehicleService;

	@Autowired
	EmailService emailService;

	@Autowired
	BillDetailsService billDetailsService;

	@GetMapping("/addToCarry/{id}")
	public String addToCart(@PathVariable int id) {
		GlobalData.cart.add(vehicleService.getProductById(id).get());
		return "redirect:/garrage";
	}

	@GetMapping("/carry")
	public String cartGet(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Vehicle::getPrice).sum());
		model.addAttribute("cart", GlobalData.cart);
		return "carry";
	}

	@GetMapping("/carry/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index) {
		GlobalData.cart.remove(index);
		return "redirect:/carry";
	}

	@GetMapping("/Invoice")
	public String checkout(@ModelAttribute BillingDetails bdt, Errors errors, HttpServletRequest request, Model model) {

		if (errors.hasErrors()) {
			return "carry";

		} else {
			System.out.println("invoice else condition");
			model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Vehicle::getPrice).sum());
			BillingDetails bd = new BillingDetails();
			model.addAttribute("billDetails", bd);
			return "Invoice";

		}
	}

	@PostMapping("/savebillingdetails")
	public String billdetails(@ModelAttribute BillingDetails bdt, @RequestParam("total") String total,
			@RequestParam("ftotal") String ftotal, HttpSession session) {

		double totalT = Double.parseDouble(total); // Long.parseLong(total);
		bdt.settAmount(totalT);
		double totalF = Double.parseDouble(ftotal);
		bdt.setpAmount(totalF);
		billDetailsService.addBillDetails(bdt);

		String email = bdt.getEmail();
		String fname = bdt.getFirstName();
		String lname = bdt.getLastName();
		String addp = bdt.getAdrressp1();
		String addpt = bdt.getAdrressp2();
		String city = bdt.getCity();
		double tAmount = bdt.gettAmount();

		String subject = "Message From  Vehicle On Rental System";
		String message = "" + "<div style='border:1px solid #e2e2e2; padding:20px'>" + "<h1>" + "Car Booked " + "<b>"
				+ "Successfully" + "<br>" + "FirstName : " + fname + "<br>" + "LastName : " + lname + "<br>"
				+ "Pick-Up your Vehicles from : " + addp + "<br>" + "Address : " + addpt + "<br>" + "City :" + city
				+ "<br>" + "Amount :" + tAmount + "</h1> " + "</div>";
		String to = email;

		boolean flag = this.emailService.sendEmail(subject, message, to);

		if (flag) {
			System.out.println("Mail Sent");
		} else {

			System.out.println("Mail Not Sent");
		}

		return "index";

	}

}
