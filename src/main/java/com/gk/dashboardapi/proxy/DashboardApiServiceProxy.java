package com.gk.dashboardapi.proxy;

import com.gk.dashboardapi.dto.DashboardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "external-api", url = "https://1.api.fy23ey05.careers.ifelsecloud.com/")
public interface DashboardApiServiceProxy {

    @GetMapping()
    public DashboardDto fetchData();
}
