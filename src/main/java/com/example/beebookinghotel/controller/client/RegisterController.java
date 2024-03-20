package com.example.beebookinghotel.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
	@GetMapping("/register")
	public String register() {
		return "Booking_Hotel/Client/register";
	}
}
