package com.example.pretkej.springpreparation.point11.two_way_relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookTwoWay {
    @Id
    private Integer id;
    private String title;
    private String genre;
    @ManyToOne
    private UserTwoWay owner;
}
