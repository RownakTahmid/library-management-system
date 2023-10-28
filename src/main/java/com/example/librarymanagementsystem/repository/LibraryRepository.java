package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
