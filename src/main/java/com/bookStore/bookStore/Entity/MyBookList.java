package com.bookStore.bookStore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "MyBooks")
public class MyBookList {
    @Id
    private Long Id;
    private String name;
    private String author;
    private String price;
}
