package com.equipo_a.ms_books_catalogue.controller;

import com.equipo_a.ms_books_catalogue.Data.Model.Libro;
import com.equipo_a.ms_books_catalogue.controller.model.CreateLibroRequest;
import com.equipo_a.ms_books_catalogue.controller.model.LibroDto;
import com.equipo_a.ms_books_catalogue.servicios.LibrosService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Libro Controller", description = "Microservicio encargado de exponer operaciones CRUD sobre Libros alojados en una base de datos en memoria.")
public class LibroController {

    private final LibrosService service;

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> getLibros(
            @RequestHeader Map<String, String> headers,
            @RequestParam (required = false) String titulo,
            @RequestParam (required = false) String autor,
            @RequestParam (required = false) String fecha,
            @RequestParam (required = false) String descripcion,
            @RequestParam (required = false) Double precio,
            @RequestParam (required = false) String isbn,
            @RequestParam (required = false) int valoracion,
            @RequestParam (required = false) String categoria,
            @RequestParam (required = false) String editorial,
            @RequestParam (required = false) Boolean visible){
        log.info("headers: {}", headers);
        List<Libro> libros = service.getLibros(titulo,autor,fecha,descripcion,precio,isbn,valoracion,categoria,editorial,visible);
        if(libros != null){
            return ResponseEntity.ok(libros);
        }else{
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
    @GetMapping("/libros/{libroId}")
    public ResponseEntity<Libro> getLibro(@PathVariable String libroId){
        Libro libro = service.getLibro(libroId);
        if(libro != null){
            return ResponseEntity.ok(libro);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/libros/{libroId}")
    public ResponseEntity<Libro> deleteLibro(@PathVariable String libroId){
        boolean deleted = service.removeLibro(libroId);

        if(Boolean.TRUE.equals(deleted)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/libros")
    public ResponseEntity<Libro> addLibro(@RequestBody CreateLibroRequest request){
        Libro libro = service.addLibro(request);
        if(libro != null){
            return ResponseEntity.ok(libro);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PatchMapping("/libros/{librosId}")
    public ResponseEntity<Libro> updateLibro(@PathVariable String librosId, @RequestBody String updateRequestString){
        Libro libro = service.updateLibro(librosId, updateRequestString);
        if(libro != null){
            return ResponseEntity.ok(libro);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/libros/{librosId}")
    public ResponseEntity<Libro> updateLibro(@PathVariable String librosId, @RequestBody LibroDto request){
        Libro libro = service.updateLibro(librosId, request);
        if(libro != null){
            return ResponseEntity.ok(libro);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
