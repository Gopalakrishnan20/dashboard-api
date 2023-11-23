package com.gk.dashboardapi.controller;

import com.gk.dashboardapi.dto.DashboardDto;
import com.gk.dashboardapi.service.DashboardApiService;
import com.gk.dashboardapi.service.IdashboardApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @Autowired
    private IdashboardApiService service;

    @GetMapping("/fetch")
    public DashboardDto fetchAllData(){
        DashboardDto data = service.callViaFeign();
        service.mapToEntity(data);
        return data;
    }

    @GetMapping("/api")
    public DashboardDto getAllData(){
        return service.getApi();
    }
    @GetMapping("/clean")
    public String cleanDatabase() {
        return service.cleanDatabase();
    }
}
