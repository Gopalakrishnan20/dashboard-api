package com.gk.dashboardapi.service;

import com.gk.dashboardapi.domain.NewUsers;
import com.gk.dashboardapi.domain.RecentOrders;
import com.gk.dashboardapi.domain.TopCards;
import com.gk.dashboardapi.dto.DashboardDto;

public interface IdashboardApiService {
    public DashboardDto getDashboardData();
    public DashboardDto callViaRestTemplate();
    public void mapToEntity(DashboardDto data);
    public DashboardDto getApi();
    public DashboardDto callViaFeign();
    public String cleanDatabase();
    public NewUsers updateNewUsers(NewUsers newUsers,String id);
    public RecentOrders updateRecentOrders(RecentOrders recentOrders,String id);
    public TopCards updateTopCards(TopCards topCards, Integer id);
}
