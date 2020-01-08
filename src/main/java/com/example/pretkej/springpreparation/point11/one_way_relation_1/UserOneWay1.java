package com.example.pretkej.springpreparation.point11.one_way_relation_1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOneWay1 {
    @Id
    private String login;
    private String password;
}
