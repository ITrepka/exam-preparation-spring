package com.example.pretkej.springpreparation.point12.service;

import com.example.pretkej.springpreparation.point12.model.Book;
import com.example.pretkej.springpreparation.point12.service.dto.BookDto;
import com.example.pretkej.springpreparation.point12.service.dto.CreateUpdateBookDto;
import com.example.pretkej.springpreparation.point12.service.mapper.BookDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.plaf.LabelUI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookDtoMapper mapper;

    private List<Book> books = new ArrayList<>();
    private static int bookId = 3;

    @PostConstruct
    public void init() {
        books.add(new Book(1, "Janko Muzykant", "Ryszard Peja"));
        books.add(new Book(2, "Poczytaj mi mamo", "Zbigniew Tysiącnoga"));
    }

    public List<BookDto> getAllBooks () {
        return books.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public BookDto createBook(CreateUpdateBookDto createBookDto) {
        Book book = mapper.toModel(createBookDto);
        book.setId(bookId++);
        books.add(book);
        return mapper.toDto(book);
    }

    public void deleteBookById(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public BookDto getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .map(mapper::toDto)
                .orElse(null);
    }

    public void updateBook(int bookId, CreateUpdateBookDto updateBookDto) {
        for (Book book: books) {
            if (book.getId() == bookId){
                book.setTitle(updateBookDto.getTitle());
                book.setAuthor(updateBookDto.getAuthor());
            }
        }
    }
}
