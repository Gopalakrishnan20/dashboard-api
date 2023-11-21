package com.gk.dashboardapi.repository;

import com.gk.dashboardapi.domain.NewUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "newUsersRepository")

public interface NewUsersRepository extends JpaRepository<NewUsers,String> {


}
