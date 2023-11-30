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
import java.util.Optional;

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

    @Override
    public NewUsers updateNewUsers(NewUsers newUsers, String id) {
        if(newUsersRepository.findAll().isEmpty()){
            return null;
        }
        newUsersRepository.deleteById(id);
        NewUsers newData = new NewUsers(
                id,
                newUsers.getPicture(),
                newUsers.getName(),
                newUsers.getActive(),
                newUsers.getCountry(),
                newUsers.getProgress());

        return newUsersRepository.save(newData);
    }

    @Override
    public RecentOrders updateRecentOrders(RecentOrders recentOrders,String id) {
        if(recentOrdersRepository.findAll().isEmpty()){
            return null;
        }
        recentOrdersRepository.deleteById(id);
        RecentOrders newData = new RecentOrders(
                id,
                recentOrders.getName(),
                recentOrders.getProduct(),
                recentOrders.getDelivery_date(),
                recentOrders.getStatus(),
                recentOrders.getTracking_no(),
                recentOrders.isShipping()
        );
        return recentOrdersRepository.save(newData);
    }

    @Override
    public TopCards updateTopCards(TopCards topCards, Integer id) {
        if(topCardsRepository.findAll().isEmpty()){
            return null;
        }
        topCardsRepository.deleteById(id);
        TopCards newData = new TopCards(
                id,
                topCards.getHeader(),
                topCards.getSubHeader(),
                topCards.getValue()
        );
        return topCardsRepository.save(newData);
    }
}
