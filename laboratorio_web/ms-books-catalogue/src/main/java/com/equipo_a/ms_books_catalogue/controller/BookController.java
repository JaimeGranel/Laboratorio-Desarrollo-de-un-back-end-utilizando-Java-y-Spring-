package com.equipo_a.ms_books_catalogue.controller;

import com.equipo_a.ms_books_catalogue.Data.Model.Book;
import com.equipo_a.ms_books_catalogue.controller.model.CreateBookRequest;
import com.equipo_a.ms_books_catalogue.controller.model.LibroDto;
import com.equipo_a.ms_books_catalogue.servicios.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService service;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getLibros(
            @RequestHeader Map<String, String> headers,
            @RequestParam (required = false) String titulo,
            @RequestParam (required = false) String autor,
            @RequestParam (required = false) String fecha,
            @RequestParam (required = false) String descripcion,
            @RequestParam (required = false) Double precio,
            @RequestParam (required = false) String isbn,
            @RequestParam (required = false) Integer valoracion,
            @RequestParam (required = false) String categoria,
            @RequestParam (required = false) String editorial,
            @RequestParam (required = false) Boolean visible){
        log.info("headers: {}", headers);

        List<Book> books = service.getBooks(titulo,autor,fecha,descripcion,precio,isbn,valoracion,categoria,editorial,visible);

        if(books != null){
            return ResponseEntity.ok(books);
        }else{
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
    @GetMapping("/books/{libroId}")
    public ResponseEntity<Book> getLibro(@PathVariable String libroId){
        Book book = service.getBook(libroId);
        if(book != null){
            return ResponseEntity.ok(book);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/books/{libroId}")
    public ResponseEntity<Book> deleteLibro(@PathVariable String libroId){
        boolean deleted = service.removeBook(libroId);

        if(Boolean.TRUE.equals(deleted)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody CreateBookRequest request){
        Book book = service.addBook(request);
        if(book != null){
            return ResponseEntity.ok(book);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PatchMapping("/books/{librosId}")
    public ResponseEntity<Book> updateBook(@PathVariable String librosId, @RequestBody String updateRequestString){
        Book book = service.updateBook(librosId, updateRequestString);
        if(book != null){
            return ResponseEntity.ok(book);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/books/{booksId}")
    public ResponseEntity<Book> updateBook(@PathVariable String booksId, @RequestBody LibroDto request){
        Book book = service.updateBook(booksId, request);
        if(book != null){
            return ResponseEntity.ok(book);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
