package com.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dao.ComplaintHibernateDao;
import com.entity.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ComplaintHibernateDao dao;

    @RequestMapping("/")
    public String adminPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            model.addAttribute("error", "Access denied. Please log in as admin.");
            return "error";
        }
        return "admin";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            model.addAttribute("error", "Access denied.");
            return "error";
        }
        model.addAttribute("list", dao.getAll());
        return "admin-dashboard";
    }

    @GetMapping("/resolve/{id}")
    public String resolve(@PathVariable int id, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            model.addAttribute("error", "Access denied.");
            return "error";
        }
        try {
            dao.updateStatus(id, "Resolved");
            model.addAttribute("message", "Complaint resolved successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Error resolving complaint: " + e.getMessage());
        }
        return "redirect:/admin/dashboard";
    }
}