package com.guillemarti.books.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BooksTest {
    public static final String EXPECTED_ISBN = "9781593275846";
    public static final String EXPECTED_TITLE = "Eloquent JavaScript, Second Edition";
    public static final String EXPECTED_SUBTITLE = "A Modern Introduction to Programming";
    public static final String EXPECTED_AUTHOR = "Marijn Haverbeke";
    public static final LocalDateTime EXPECTED_PUBLISHED = LocalDateTime.parse("2014-12-14T00:00:00");
    public static final String EXPECTED_PUBLISHER = "No Starch Press";
    public static final String EXPECTED_IMAGE = "eloquent-javascript.jpg";
    public static final int EXPECTED_PAGES = 300;
    public static final String EXPECTED_DESCRIPTION = "JavaScript lies at the heart of almost every modern web application, from social apps to the newest browser-based games. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale applications.";
    public static final String EXPECTED_WEBSITE = "https://website.com";
    public static final String EXPECTED_CATEGORY = "computer";
    private Books book;

    @BeforeEach
    public void setUp() throws Exception {
        book = new Books(
                0,
                "9781593275846",
                "Eloquent JavaScript, Second Edition",
                "A Modern Introduction to Programming",
                "Marijn Haverbeke",
                LocalDateTime.parse("2014-12-14T00:00:00"),
                "No Starch Press",
                "eloquent-javascript.jpg",
                300,
                "JavaScript lies at the heart of almost every modern web application, from social apps to the newest browser-based games. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale applications.",
                "https://website.com",
                "computer"
                );
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test completed");
    }

    @Test
    void testBooks() {
        assertEquals(EXPECTED_ISBN, book.getIsbn());
        assertEquals(EXPECTED_TITLE, book.getTitle());
        assertEquals(EXPECTED_SUBTITLE, book.getSubtitle());
        assertEquals(EXPECTED_AUTHOR, book.getAuthor());
        assertEquals(EXPECTED_PUBLISHED, book.getPublished());
        assertEquals(EXPECTED_IMAGE, book.getImage());
        assertEquals(EXPECTED_PAGES, book.getPages());
        assertEquals(EXPECTED_PUBLISHER, book.getPublisher());
        assertEquals(EXPECTED_DESCRIPTION, book.getDescription());
        assertEquals(EXPECTED_WEBSITE, book.getWebsite());
        assertEquals(EXPECTED_CATEGORY, book.getCategory());
    }

    @Test
    void setNewIDTest() {
        int id = 5;
        book.setId(id);
        assertEquals(id, book.getId());
    }
}