package com.gk.dashboardapi.service;

import com.gk.dashboardapi.dto.DashboardDto;

public interface IdashboardApiService {
    public DashboardDto getDashboardData();
    public DashboardDto callApi();
    public void mapToEntity(DashboardDto data);
    public DashboardDto getApi();
}
