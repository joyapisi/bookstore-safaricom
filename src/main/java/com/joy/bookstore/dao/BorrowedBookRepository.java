package com.joy.bookstore.dao;
import com.joy.bookstore.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Integer> {
    List<BorrowedBook> findByUserId(Long userId);

    Optional<BorrowedBook> findByUserIdAndBookId(Long userId, Long bookId);
}
