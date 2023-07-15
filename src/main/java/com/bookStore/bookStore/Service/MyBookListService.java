package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Entity.MyBookList;
import com.bookStore.bookStore.Repository.MyBookListRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyBookListService {
    private final MyBookListRepo myBookListRepo;

    public void saveMyBooks(MyBookList bookList) {
        myBookListRepo.save(bookList);
    }

    public List<MyBookList> getAllMyBooks() {
        return myBookListRepo.findAll();
    }

    public void deleteById(Long id) {
        myBookListRepo.deleteById(id);
    }
}
