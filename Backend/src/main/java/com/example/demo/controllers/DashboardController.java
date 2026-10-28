package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.daos.DashboardService;
import com.example.demo.entities.DashboardDTO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class DashboardController {
	 @Autowired
	    private DashboardService dashboardService;
	
	@GetMapping("/dashboard")
    public DashboardDTO getDashboard() {
        return dashboardService.getDashboardData();
    }

}
