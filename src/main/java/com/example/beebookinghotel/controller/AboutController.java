package com.example.beebookinghotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
	@GetMapping("/about")
	public String about() {
		return "Booking_Hotel/Client/about";
	}
}
