package com.example.pretkej.springpreparation.point12.view;

import com.example.pretkej.springpreparation.point12.service.BookService;
import com.example.pretkej.springpreparation.point12.service.dto.BookDto;
import com.example.pretkej.springpreparation.point12.service.dto.CreateUpdateBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BooksViewController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ModelAndView displayBooksTable() {
        List<BookDto> allBooks = bookService.getAllBooks();
        ModelAndView mv = new ModelAndView("books-table");
        mv.addObject("books", allBooks);
        return mv;
    }

    @GetMapping("/create-book")
    public ModelAndView displayCreateBookForm(){
        ModelAndView modelAndView = new ModelAndView("create-book");
        modelAndView.addObject("createDto", new CreateUpdateBookDto());
        return modelAndView;
    }

    @PostMapping("/create-book")
    public ModelAndView createBookFromForm(@ModelAttribute(name = "createDto")CreateUpdateBookDto createBookDto) {
        bookService.createBook(createBookDto);

        return new ModelAndView("redirect:/books");
    }

    @GetMapping("/delete-book")
    public ModelAndView deleteBook(@RequestParam int id){
        bookService.deleteBookById(id);

        return new ModelAndView("redirect:/books");
    }

    @GetMapping("/edit-book/{bookId}")
    public ModelAndView displayEditBookForm(@PathVariable Integer bookId){
        ModelAndView mv = new ModelAndView("edit-book");
        BookDto bookById = bookService.getBookById(bookId);
        CreateUpdateBookDto dto = new CreateUpdateBookDto(bookById.getTitle(), bookById.getAuthor());
        mv.addObject("updateDto", dto);
        return mv;
    }

    @PostMapping("/edit-book/{bookId}")
    public ModelAndView editBook(@PathVariable Integer bookId, @ModelAttribute(name = "updateDto") CreateUpdateBookDto updateBookDto){
        bookService.updateBook(bookId, updateBookDto);
        return new ModelAndView("redirect:/books");
    }
}
