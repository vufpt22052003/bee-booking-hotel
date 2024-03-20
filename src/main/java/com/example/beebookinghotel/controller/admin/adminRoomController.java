package com.example.beebookinghotel.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminRoomController {
    @GetMapping("/admin/room")
    public String adminRoom() {
        return "Booking_Hotel/Admin/quanlyphong";
    }
}
