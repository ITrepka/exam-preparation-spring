package com.example.pretkej.springpreparation.point11.two_way_relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTwoWayRepository extends JpaRepository<BookTwoWay, Integer> {
}
