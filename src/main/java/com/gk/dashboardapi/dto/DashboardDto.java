package com.gk.dashboardapi.dto;

import com.gk.dashboardapi.domain.NewUsers;
import com.gk.dashboardapi.domain.RecentOrders;
import com.gk.dashboardapi.domain.TopCards;

import java.util.List;

public class DashboardDto {

    private List<TopCards> listOfTopCards;
    private List<NewUsers> listOfNewUsers;
    private List<RecentOrders>listOfRecentOrders;

    public DashboardDto(List<TopCards> listOfTopCards, List<NewUsers> listOfNewUsers, List<RecentOrders> listOfRecentOrders) {
        this.listOfTopCards = listOfTopCards;
        this.listOfNewUsers = listOfNewUsers;
        this.listOfRecentOrders = listOfRecentOrders;
    }

    public DashboardDto() {
    }

    public List<TopCards> getListOfTopCards() {
        return listOfTopCards;
    }

    public void setListOfTopCards(List<TopCards> listOfTopCards) {
        this.listOfTopCards = listOfTopCards;
    }

    public List<NewUsers> getListOfNewUsers() {
        return listOfNewUsers;
    }

    public void setListOfNewUsers(List<NewUsers> listOfNewUsers) {
        this.listOfNewUsers = listOfNewUsers;
    }

    public List<RecentOrders> getListOfRecentOrders() {
        return listOfRecentOrders;
    }

    public void setListOfRecentOrders(List<RecentOrders> listOfRecentOrders) {
        this.listOfRecentOrders = listOfRecentOrders;
    }

    @Override
    public String toString() {
        return "DashboardDto{" +
                "listOfTopCards=" + listOfTopCards +
                ", listOfNewUsers=" + listOfNewUsers +
                ", listOfRecentOrders=" + listOfRecentOrders +
                '}';
    }
}
