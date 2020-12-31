package com.guillemarti.books.controller;

import com.guillemarti.books.model.Books;
import com.guillemarti.books.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @GetMapping(value="/list")
    public String showBookList(ModelMap model) {
        model.put("books", bookServiceImpl.getAllBooks());
        return "bookList";
    }

    @GetMapping(value="/{id}")
    public String showBookDetailPage(@PathVariable int id, ModelMap model) {
        model.put("books", bookServiceImpl.getBookById(id));
        return "bookDetail";
    }

    @GetMapping(value="/new")
    public String showNewBookPage(ModelMap model) {
        model.put("book", new Books(0,"","","","", LocalDateTime.now(),"","",0,"","",""));
        return "newBook";
    }

    @PostMapping(value="/add-book")
    public String addBook(Books book, BindingResult result) {
        if (result.hasErrors()) {
            return "newBook";
        }
        bookServiceImpl.addBook(book);
        return "redirect:/book/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String showUpdateBookPage(@PathVariable int id, ModelMap model) {
        model.put("book", bookServiceImpl.getBookById(id).get(0));
        return "updateBook";
    }

    //@DeleteMapping(value = "/delete/{id}")
    @RequestMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookServiceImpl.deleteBook(id);
        return "redirect:/book/list";
    }
}
