package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.Library;
import com.example.librarymanagementsystem.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public Library addNewBook(Library book){
        return libraryRepository.save(book);
    }
    public List<Library> addNewBooks(List<Library> books){
        return libraryRepository.saveAll(books);
    }
    public List<Library>  showTheListOfBooks(){
        return libraryRepository.findAll();
    }
    public Library borrowBookById(int id){
        Library availableBook = libraryRepository.findById(id).orElse(null);
        if (availableBook != null && availableBook.getNumOfCopies() >0){
            availableBook.setNumOfCopies(availableBook.getNumOfCopies()-1);
            libraryRepository.save(availableBook);
        }else {
            throw new IllegalStateException("No available copies of "+ availableBook.getBookName() + " is available");
        }
        return availableBook;

    }
    public Library returnBookById(int id){
        Library availableBook = libraryRepository.findById(id).orElse(null);
        availableBook.setNumOfCopies(availableBook.getNumOfCopies()+1);
        libraryRepository.save(availableBook);
        return availableBook;
    }
    public String deleteBooks(){
        libraryRepository.deleteAll();
        return "All records deleted!!";
    }
}
