package com.example.beebookinghotel.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminHomeController {
    @GetMapping("/admin")
    public String adminRoom() {
        return "Booking_Hotel/Admin/index";
    }
}
