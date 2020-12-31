package com.guillemarti.books.repository;

import com.guillemarti.books.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Integer> {
    List<Books> findAll();
    List<Books> findById(int id);
}
