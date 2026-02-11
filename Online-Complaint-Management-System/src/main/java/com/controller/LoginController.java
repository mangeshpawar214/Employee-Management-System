package com.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dao.UserJdbcDao;
import com.entity.User;

@Controller
public class LoginController {

    @Autowired
    private UserJdbcDao dao;


    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        try {
            User u = dao.login(email, password);
            if (u != null) {
                session.setAttribute("user", u);
                if ("ADMIN".equals(u.getRole())) {
                    return "redirect:/admin/dashboard";
                } else {
                    return "redirect:/user/dashboard"; // New: User dashboard
                }
            } else {
                model.addAttribute("error", "Invalid email or password.");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Login failed: " + e.getMessage());
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}