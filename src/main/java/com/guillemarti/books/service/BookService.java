package com.guillemarti.books.service;

import com.guillemarti.books.model.Books;

import java.util.List;

public interface BookService {
    List<Books> getBookById(int id);
    List<Books> getAllBooks();
    void addBook(Books book);
    void deleteBook(int id);
}
