package com.gk.dashboardapi.repository;

import com.gk.dashboardapi.domain.TopCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "topCardsRepository")
public interface TopCardsRepository extends JpaRepository<TopCards,Integer> {
}
