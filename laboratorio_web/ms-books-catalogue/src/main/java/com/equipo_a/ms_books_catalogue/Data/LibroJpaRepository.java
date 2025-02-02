package com.equipo_a.ms_books_catalogue.Data;

import com.equipo_a.ms_books_catalogue.Data.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface LibroJpaRepository  extends JpaRepository<Libro, Long>, JpaSpecificationExecutor<Libro> {
    
    List<Libro> findByTitulo(String titulo);
    List<Libro> findByAutor(String autor);
    List<Libro> findByEditorialAndAutor(String editorial, String autor);
    List<Libro> findByIsbn(String isbn);
}
