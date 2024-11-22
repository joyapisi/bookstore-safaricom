package com.joy.bookstore.service;

import com.joy.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(int id);
    Book save(Book book);
    void deleteById(int id);
}
