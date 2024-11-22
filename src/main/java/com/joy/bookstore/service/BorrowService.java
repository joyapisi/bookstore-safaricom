package com.joy.bookstore.service;

import com.joy.bookstore.dao.BookRepository;
import com.joy.bookstore.dao.BorrowedBookRepository;
import com.joy.bookstore.dao.UserRepository;
import com.joy.bookstore.entity.Book;
import com.joy.bookstore.entity.BorrowedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    public String borrowBook(String requestId, Long userId, Long bookId) {
        // Validate user exists
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User not found");
        }

        // Validate book exists
        Book book = bookRepository.findById(Math.toIntExact(bookId))
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        // Check borrowed book limits
        List<BorrowedBook> borrowedBooks = borrowedBookRepository.findByUserId(userId);
        if (borrowedBooks.size() >= 3) {
            throw new IllegalArgumentException("User has already borrowed 3 books");
        }

        // Check total value limit
        int totalValue = borrowedBooks.stream()
                .map(b -> bookRepository.findById(Math.toIntExact(b.getBookId())).orElseThrow())
                .mapToInt(Book::getPrice)
                .sum();
        if (totalValue + book.getPrice() > 5000) {
            throw new IllegalArgumentException("Total value of borrowed books exceeds 5000");
        }

        // Borrow book
        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setRequestId(requestId);
        borrowedBook.setUserId(userId);
        borrowedBook.setBookId(bookId);
        borrowedBookRepository.save(borrowedBook);

        return "Book borrowed successfully";
    }



    public String returnBook(Long userId, Long bookId) {
        // Find the borrowed book record
        BorrowedBook borrowedBook = borrowedBookRepository.findByUserIdAndBookId(userId, bookId)
                .orElseThrow(() -> new IllegalArgumentException("No record found for the borrowed book with the specified user and book ID"));

        // Delete the record
        borrowedBookRepository.delete(borrowedBook);

        return "Book returned successfully";
    }
}

