package com.example.beebookinghotel.controller;

import com.example.beebookinghotel.Service.AccountService;
import com.example.beebookinghotel.entity.Account;
import com.example.beebookinghotel.model.dto.AccountDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final AccountService accountService;

    @RequestMapping("/formLogin")
    public String formLogin() {
        return "/login";
    }

    @RequestMapping("/loginFail")
    public String failureForwardUrl(Model model) {
        model.addAttribute("message", "Tài khoản không tồn tài");
        return "/login";
    }


    @RequestMapping("/login")
    public String login(HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String roleAuthentication = authentication.getAuthorities().toString();
            String[] roleAccount = roleAuthentication.split("_");
            String role = roleAccount[1].replace("]", "");

            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                Optional<Account> optionalAccount = accountService.findByEmail(userDetails.getUsername());
                if (optionalAccount.isPresent()) {
                    session.setAttribute("acc", optionalAccount.get());
                    return "Booking_Hotel/User/HomePage/index";
                } else {
                    System.err.println("Không tìm thấy tài khoản liên kết");
                    return "/login";
                }
            } else {
                System.err.println("Không có thông tin xác thực");
                return "/login";
            }
        } else {
            System.err.println("Không có thông tin xác thực");
            return "redirect:/formLogin";
        }
    }

}
