package com.equipo_a.ms_books_catalogue.servicios;

import com.equipo_a.ms_books_catalogue.Data.Model.Libro;
import com.equipo_a.ms_books_catalogue.controller.model.CreateLibroRequest;
import com.equipo_a.ms_books_catalogue.controller.model.LibroDto;

import java.util.List;

public interface LibrosService {

    List<Libro> getLibros(String titulo, String autor, String fecha,String descripcion,Double precio ,String isbn, int valoracion,String categoria, String editorial, Boolean visible);

    Libro getLibro(String id);
    Boolean removeLibro(String id);
    Libro addLibro(CreateLibroRequest request);
    Libro updateLibro(String id, LibroDto updateRequest);
    Libro updateLibro(String id, String updateRequestString);

}
