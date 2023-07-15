package com.bookStore.bookStore.Controllers;


import com.bookStore.bookStore.Entity.Book;
import com.bookStore.bookStore.Entity.MyBookList;
import com.bookStore.bookStore.Service.BookService;
import com.bookStore.bookStore.Service.MyBookListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final MyBookListService myBookListService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Book> list = bookService.getAllBooks();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("bookList");
//        modelAndView.addObject("book", list);
        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public ModelAndView myBooks() {
        List<MyBookList> list = myBookListService.getAllMyBooks();
        return new ModelAndView("myBooks", "book", list);
    }

    @GetMapping("/mylist/{id}")
    public String getMyBookList(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
        myBookListService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/available_books";
    }

}
