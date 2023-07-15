package com.bookStore.bookStore.Controllers;

import com.bookStore.bookStore.Service.MyBookListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MyBookListController {
    private final MyBookListService myBookListService;

    @GetMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") Long id) {
        myBookListService.deleteById(id);
        return "redirect:/my_books";
    }
}
