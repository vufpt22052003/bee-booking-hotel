package com.example.beebookinghotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomsController {
	@GetMapping("/rooms")
	public String rooms() {
		return "Booking_Hotel/Client/rooms";
	}
}
