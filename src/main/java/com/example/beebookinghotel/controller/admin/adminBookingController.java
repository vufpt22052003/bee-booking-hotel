package com.example.beebookinghotel.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminBookingController {
    @GetMapping("/admin/booking")
    public String adminRoom() {
        return "Booking_Hotel/Admin/quanlydonhang";
    }
}
