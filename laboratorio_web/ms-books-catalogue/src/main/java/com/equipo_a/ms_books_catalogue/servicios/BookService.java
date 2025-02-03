package com.equipo_a.ms_books_catalogue.servicios;

import com.equipo_a.ms_books_catalogue.Data.Model.Book;
import com.equipo_a.ms_books_catalogue.controller.model.CreateBookRequest;
import com.equipo_a.ms_books_catalogue.controller.model.LibroDto;

import java.util.List;

public interface BookService {

    List<Book> getBooks(String titulo, String autor, String fecha, String descripcion, Double precio , String isbn, Integer valoracion, String categoria, String editorial, Boolean visible);

    Book getBook(String id);
    Boolean removeBook(String id);
    Book addBook(CreateBookRequest request);
    Book updateBook(String id, LibroDto updateRequest);
    Book updateBook(String id, String updateRequestString);

}
