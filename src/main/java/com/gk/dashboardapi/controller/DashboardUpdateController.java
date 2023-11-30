package com.gk.dashboardapi.controller;

import com.gk.dashboardapi.domain.NewUsers;
import com.gk.dashboardapi.domain.RecentOrders;
import com.gk.dashboardapi.domain.TopCards;
import com.gk.dashboardapi.service.IdashboardApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
public class DashboardUpdateController {

    @Autowired
    private IdashboardApiService service;

    @PutMapping("/newUsers/{id}")
    public NewUsers updateNewUser(@RequestBody NewUsers newUsers,@PathVariable String id){
        return service.updateNewUsers(newUsers,id);
    }

    @PutMapping("/recentorders/{id}")
    public RecentOrders updateRecentOrders(@RequestBody RecentOrders recentOrders,@PathVariable String id){
        return service.updateRecentOrders(recentOrders,id);

    }

    @PutMapping("/topCards/{id}")
    public TopCards updateTopCards(@RequestBody TopCards topCards,@PathVariable Integer id){
        return service.updateTopCards(topCards,id);
    }

}
