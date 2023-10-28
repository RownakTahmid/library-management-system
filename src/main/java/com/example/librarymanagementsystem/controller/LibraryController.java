package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Library;
import com.example.librarymanagementsystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/books")
    public List<Library> findAllBooks(){
        return libraryService.showTheListOfBooks();
    }
    @PostMapping("/add_books")
    public List<Library> addNewBooks(@RequestBody List<Library> books){
        return libraryService.addNewBooks(books);
    }
    @PostMapping("/add-book")
    public Library addNewBook(@RequestBody Library library){
        return libraryService.addNewBook(library);
    }
    @PutMapping("/books/borrow/{id}")
    public Library acquireBookById(@PathVariable int id){
        return libraryService.borrowBookById(id);
    }
    @PutMapping("books/return/{id}")
    public Library handInBookById(@PathVariable int id){
        return libraryService.returnBookById(id);
    }
    @DeleteMapping("/delete-books")
    public String deleteLibrary(){
        return libraryService.deleteBooks();
    }

}
