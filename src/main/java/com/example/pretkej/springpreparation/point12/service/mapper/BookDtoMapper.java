package com.example.pretkej.springpreparation.point12.service.mapper;

import com.example.pretkej.springpreparation.point12.model.Book;
import com.example.pretkej.springpreparation.point12.service.dto.BookDto;
import com.example.pretkej.springpreparation.point12.service.dto.CreateUpdateBookDto;
import org.springframework.stereotype.Component;

@Component
public class BookDtoMapper {

    public BookDto toDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

    public Book toModel(CreateUpdateBookDto createBookDto) {
        return Book.builder()
                .author(createBookDto.getAuthor())
                .title(createBookDto.getTitle())
                .build();
    }
}
