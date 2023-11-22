package com.gk.dashboardapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gk.dashboardapi.domain.NewUsers;
import com.gk.dashboardapi.domain.RecentOrders;
import com.gk.dashboardapi.domain.TopCards;

import java.util.List;

public class DashboardDto {

    @JsonProperty("top_cards")
    private List<TopCards> top_cards;

    @JsonProperty("new_users")
    private List<NewUsers> new_users;

    @JsonProperty("recent_orders")
    private List<RecentOrders>recent_orders;

    public DashboardDto(List<TopCards> top_cards, List<NewUsers> new_users, List<RecentOrders> recent_orders) {
        this.top_cards = top_cards;
        this.new_users = new_users;
        this.recent_orders = recent_orders;
    }

    public List<TopCards> getTop_cards() {
        return top_cards;
    }

    public void setTop_cards(List<TopCards> top_cards) {
        this.top_cards = top_cards;
    }

    public List<NewUsers> getNew_users() {
        return new_users;
    }

    public void setNew_users(List<NewUsers> new_users) {
        this.new_users = new_users;
    }

    public List<RecentOrders> getRecent_orders() {
        return recent_orders;
    }

    public void setRecent_orders(List<RecentOrders> recent_orders) {
        this.recent_orders = recent_orders;
    }

    public DashboardDto() {
    }

    @Override
    public String toString() {
        return "DashboardDto{" +
                "top_cards=" + top_cards +
                ", new_users=" + new_users +
                ", recent_orders=" + recent_orders +
                '}';
    }
}
