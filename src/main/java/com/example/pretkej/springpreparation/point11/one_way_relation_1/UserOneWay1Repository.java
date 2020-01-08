package com.example.pretkej.springpreparation.point11.one_way_relation_1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOneWay1Repository extends JpaRepository<UserOneWay1, String> {
}
