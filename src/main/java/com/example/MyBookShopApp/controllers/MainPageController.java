package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Контроллер главной страницы
 */


@Controller
@RequestMapping("/bookshop")
public class MainPageController {

    private final BookService bookService;


    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("bookData", bookService.getBooksData());
        model.addAttribute("searchPlaceholder", "new search placeholder");
        model.addAttribute("serverTime", new SimpleDateFormat("hh:mm:ss").format(new Date()));
        model.addAttribute("placeholderTextPart2", "SERVER");
        model.addAttribute("messageTemplate", "searchbar.placeholder2");

        return "main";
    }


    @GetMapping("/genres")
    public String genresPage() {

        return "genres";
    }

    @GetMapping("/authors")
    public String authorsPage() {

        return "authors";
    }



}
