package com.gk.dashboardapi.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service(value = "dashboardApiService")
public class DashboardApiService {

    private RestTemplate restTemplate;

    private static final String url="https://1.api.fy23ey05.careers.ifelsecloud.com/";
    public Object getDashboardData(){
        try {
            HttpHeaders headers =new HttpHeaders();
            headers.set("Accept","*/*");
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(headers),String.class);
            return response.getBody();

        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT,
                    "Exception while calling public API.",
                    e
            );
        }
    }


}
