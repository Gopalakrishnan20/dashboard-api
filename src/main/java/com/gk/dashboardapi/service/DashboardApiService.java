package com.gk.dashboardapi.service;

import com.gk.dashboardapi.dto.DashboardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service(value = "dashboardApiService")
public class DashboardApiService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String url="https://1.api.fy23ey05.careers.ifelsecloud.com/";
    public Object getDashboardData(){
        try {
            return restTemplate.getForObject(url, Object.class);

        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling public API.",
                    e
            );
        }
    }


}
