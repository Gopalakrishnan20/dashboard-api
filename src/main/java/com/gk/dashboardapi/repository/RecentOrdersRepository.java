package com.gk.dashboardapi.repository;

import com.gk.dashboardapi.domain.RecentOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "recentordersRepository")
public interface RecentOrdersRepository extends JpaRepository<RecentOrders,String> {

}
