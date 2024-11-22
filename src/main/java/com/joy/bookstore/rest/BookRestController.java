package com.joy.bookstore.rest;


import com.joy.bookstore.entity.Book;
import com.joy.bookstore.service.BookService;
import com.joy.bookstore.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 @RequestMapping("/api")
public class BookRestController {

    private BookService bookService;

    @Autowired
    private BorrowService borrowService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/book/{book_id}")
    public Book findById(@PathVariable int bookId){
        Book book = bookService.findById(bookId);
        if(book == null){
            throw new RuntimeException("Book with id " + bookId + " not found");
        }
        return book;
    }

    @PostMapping("book")
    public Book save(@RequestBody Book book) {
        book.setId(0);
        Book savedBook = bookService.save(book);
        return savedBook;
    }


    //updating book
    @PutMapping("book/{bookId}")
    public Book update(@PathVariable int bookId, @RequestBody Book book) {
        Book updatedBook = bookService.save(book);
        return bookService.save(updatedBook);

    }

    @DeleteMapping("book/{bookId}")
    public String delete(@PathVariable int bookId) {
        Book book = bookService.findById(bookId);
        if(book == null){
            throw new RuntimeException("Book with id " + bookId + " not found");
        }
        bookService.deleteById(bookId);
        return "Book with id " + bookId + " deleted successfully";
    }

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(
            @RequestParam String requestId,
            @RequestParam Long userId,
            @RequestParam Long bookId) {
        try {
            String response = borrowService.borrowBook(requestId, userId, bookId);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @DeleteMapping("/borrow")
    public ResponseEntity<String> returnBook(
            @RequestParam Long userId,
            @RequestParam Long bookId) {
        try {
            String response = borrowService.returnBook(userId, bookId);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
