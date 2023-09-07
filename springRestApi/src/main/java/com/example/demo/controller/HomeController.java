package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Books;
import com.example.demo.service.BookService;


@RestController
@Component
public class HomeController {


    @Autowired
    private BookService bookservice;

    @GetMapping("/books")
    public ResponseEntity<List<Books>> getBooks() {
        System.out.println("it is getBook");
        List<Books> list = bookservice.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity(list, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/books/{id}")

    public ResponseEntity<Books> findById(@PathVariable("id") int id) {
        System.out.println("it is afindById");
        Books book = bookservice.findById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public ResponseEntity<Books> addBooks(@RequestBody Books book) {
        System.out.println("it is addBook");
        Books b = null;
        try {
            b = bookservice.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteB(@PathVariable int id) {
        System.out.println("it is delete");
        try {
            bookservice.deletBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Books> updateBook(@RequestBody Books book, @PathVariable("id") int bookId) {
        System.out.println("it is update");
        try {
            bookservice.updateBook(book, bookId);
            return ResponseEntity.ok().body(book);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<?> getAllBooks(@PathVariable int id) {
        return bookservice.getBookById(id);
    }

    @GetMapping("/getBookByAuthName/{name}")
    public ResponseEntity<?> getByAutherName(@PathVariable String name) {
        return bookservice.getBookByAutherName(name);
    }
}
