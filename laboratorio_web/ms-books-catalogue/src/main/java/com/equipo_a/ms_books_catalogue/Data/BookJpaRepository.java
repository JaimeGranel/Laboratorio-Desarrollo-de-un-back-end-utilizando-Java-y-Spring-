package com.equipo_a.ms_books_catalogue.Data;

import com.equipo_a.ms_books_catalogue.Data.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    
    List<Book> findByTitulo(String titulo);
    List<Book> findByAutor(String autor);
    List<Book> findByEditorialAndAutor(String editorial, String autor);
    List<Book> findByIsbn(String isbn);
}
