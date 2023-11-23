package com.gk.dashboardapi.service;

import com.gk.dashboardapi.domain.NewUsers;
import com.gk.dashboardapi.domain.RecentOrders;
import com.gk.dashboardapi.domain.TopCards;
import com.gk.dashboardapi.dto.DashboardDto;
import com.gk.dashboardapi.proxy.DashboardApiServiceProxy;
import com.gk.dashboardapi.repository.NewUsersRepository;
import com.gk.dashboardapi.repository.RecentOrdersRepository;
import com.gk.dashboardapi.repository.TopCardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service(value = "dashboardApiService")
public class DashboardApiService implements IdashboardApiService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private NewUsersRepository newUsersRepository;
    @Autowired
    private RecentOrdersRepository recentOrdersRepository;
    @Autowired
    private TopCardsRepository topCardsRepository;
    @Autowired
    private DashboardApiServiceProxy dashboardApiServiceProxy;

    private static final String url="https://1.api.fy23ey05.careers.ifelsecloud.com/";
    @Override
    public DashboardDto getDashboardData(){
        try {
            DashboardDto data = restTemplate.getForObject(url, DashboardDto.class);
            return data;

        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling public API.",
                    e
            );
        }
    }
    @Override
    public DashboardDto callViaRestTemplate(){
        DashboardDto data = getDashboardData();
        return data;
    }

    @Override
    public void mapToEntity(DashboardDto data) {
        List<NewUsers> listOfNewUsers = data.getNew_users();
        List<RecentOrders> listOfRecentOrders = data.getRecent_orders();
        List<TopCards> listOfTopCards = data.getTop_cards();

        newUsersRepository.saveAll(listOfNewUsers);
        recentOrdersRepository.saveAll(listOfRecentOrders);
        topCardsRepository.saveAll(listOfTopCards);

    }

    @Override
    public DashboardDto getApi() {
        List<NewUsers> listOfNewUsers = newUsersRepository.findAll();
        List<RecentOrders> listOfRecentOrders = recentOrdersRepository.findAll();
        List<TopCards> listOfTopCards = topCardsRepository.findAll();

        DashboardDto data = new DashboardDto(listOfTopCards,listOfNewUsers,listOfRecentOrders);
        return data;

    }
    @Override
    public DashboardDto callViaFeign() {
        DashboardDto data = dashboardApiServiceProxy.fetchData();
        return data;
    }
    @Override
    public String cleanDatabase() {
        newUsersRepository.deleteAll();
        topCardsRepository.deleteAll();
        recentOrdersRepository.deleteAll();
        return("DB is clean now../fetch again to retrive data from /api");

    }
}
