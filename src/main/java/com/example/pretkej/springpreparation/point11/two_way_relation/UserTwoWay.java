package com.example.pretkej.springpreparation.point11.two_way_relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTwoWay {
    @Id
    private String login;
    private String password;
    @OneToMany(mappedBy = "owner")
    private List<BookTwoWay> books = new ArrayList<>();

    public void addBook(BookTwoWay book) {
        book.setOwner(this);
        books.add(book);
    }
}
