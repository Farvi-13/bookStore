package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookListRepo extends JpaRepository<MyBookList, Long> {

}
