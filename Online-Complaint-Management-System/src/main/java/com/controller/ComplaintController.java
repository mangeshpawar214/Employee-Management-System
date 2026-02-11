package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.dao.ComplaintHibernateDao;
import com.dao.ComplaintJdbcDao;
import com.entity.Complaint;

@Controller
public class ComplaintController {

    @Autowired
    private ComplaintJdbcDao jdbcDao;

    @Autowired
    private ComplaintHibernateDao hibDao;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/")
    public String home() {
        return "add-complaint";
    }

    @PostMapping("/save")
    public String save(Complaint c, Model model) {
        if (c.getTitle() == null || c.getTitle().isEmpty() || c.getDescription() == null || c.getDescription().isEmpty()) {
            model.addAttribute("error", "Title and description are required.");
            return "add-complaint";
        }
        try {
            jdbcDao.save(c);
            model.addAttribute("message", "Complaint submitted successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Error saving complaint: " + e.getMessage());
        }
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", hibDao.getAll());
        return "complaint-list";
    }
}