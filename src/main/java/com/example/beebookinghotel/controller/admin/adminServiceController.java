package com.example.beebookinghotel.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminServiceController {
    @GetMapping("/admin/service")
    public String adminRoom() {
        return "Booking_Hotel/Admin/quanlydichvu";
    }
}
