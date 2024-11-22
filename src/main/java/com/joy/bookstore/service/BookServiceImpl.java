package com.joy.bookstore.service;


import com.joy.bookstore.dao.BookRepository;
import com.joy.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        Book bookFound = book.orElse(null);

        if (book.isPresent()) {
            bookFound = book.get();
        }else{
            throw new RuntimeException("Book not found");
        }
        return bookFound;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);

    }
}
