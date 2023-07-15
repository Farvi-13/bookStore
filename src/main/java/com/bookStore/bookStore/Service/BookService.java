package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Entity.Book;
import com.bookStore.bookStore.Repository.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepo bookRepo;

    public void save(Book book) {
        bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepo.findById(id).get();
    }

    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }
}
