package com.gk.dashboardapi.controller;

import com.gk.dashboardapi.service.DashboardApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @Autowired
    private DashboardApiService service;

    @GetMapping("/api")
    public Object getAllData(){
        return service.getDashboardData();
    }
}
