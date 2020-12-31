package com.guillemarti.books.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="isbn", length = 13)
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "author")
    private String author;

    @Column(name = "published")
    private LocalDateTime published;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "image")
    private String image;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "description", length=500)
    private String description;

    @Column(name = "website")
    private String website;

    @Column(name = "category")
    private String category;
}
