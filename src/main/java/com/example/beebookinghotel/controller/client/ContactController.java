package com.example.beebookinghotel.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
	@GetMapping("/contact")
	public String contact() {
		return "Booking_Hotel/Client/contact";
	}
}
