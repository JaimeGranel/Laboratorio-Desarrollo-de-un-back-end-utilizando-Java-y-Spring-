package com.equipo_a.ms_books_catalogue.servicios;

import com.equipo_a.ms_books_catalogue.Data.LibroRepository;
import com.equipo_a.ms_books_catalogue.Data.Model.Libro;
import com.equipo_a.ms_books_catalogue.controller.model.CreateLibroRequest;
import com.equipo_a.ms_books_catalogue.controller.model.LibroDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LibrosServicelmpl implements LibrosService {


    private final LibroRepository repositori;

    private final ObjectMapper mapper;

    @Override
    public List<Libro> getLibros(String titulo, String autor, String fecha, String descripcion, Double precio, String isbn, int valoracion, String categoria, String editorial, Boolean visible) {
        if(StringUtils.hasLength(titulo) || StringUtils.hasLength(autor) || StringUtils.hasLength(fecha) ||
                StringUtils.hasLength(descripcion) || precio != null || StringUtils.hasLength(isbn) ||
                valoracion > 0 || StringUtils.hasLength(categoria) || StringUtils.hasLength(editorial) || visible != null){
            return repositori.search(titulo,autor,fecha,descripcion,precio,isbn,valoracion,categoria,editorial,visible);
        }
        List<Libro> libros = repositori.getLibros();
        return libros.isEmpty() ? null : libros;
    }

    @Override
    public Libro getLibro(String id) {
        return repositori.getById(Long.valueOf(id));
    }

    @Override
    public Boolean removeLibro(String id) {

        Libro product = repositori.getById(Long.valueOf(id));

        if (product != null) {
            repositori.delete(product);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Libro addLibro(CreateLibroRequest request) {
        if (request != null && StringUtils.hasLength(request.getTitulo().trim())
                && StringUtils.hasLength(request.getAutor().trim())
                && StringUtils.hasLength(request.getFecha().trim())
                && StringUtils.hasLength(request.getDescripcion().trim())
                && request.getPrecio() != null
                && StringUtils.hasLength(request.getIsbn().trim())
                && request.getValoracion() >= 0
                && StringUtils.hasLength(request.getCategoria().trim())
                && StringUtils.hasLength(request.getEditorial().trim())
                && request.getVisible() != null) {


            Libro libro = Libro.builder()
                    .titulo(request.getTitulo())
                    .autor(request.getAutor())
                    .fecha(request.getFecha())
                    .descripcion(request.getDescripcion())
                    .precio(request.getPrecio())
                    .isbn(request.getIsbn())
                    .valoracion(request.getValoracion())
                    .categoria(request.getCategoria())
                    .editorial(request.getEditorial())
                    .visible(request.getVisible())
                    .build();


            return repositori.save(libro);
        } else {
            return null;
        }
    }

    @Override
    public Libro updateLibro(String id, LibroDto updateRequest) {
        Libro libro = repositori.getById(Long.valueOf(id));
        if (libro != null) {
            libro.update(updateRequest);
            repositori.save(libro);
            return libro;
        } else {
            return null;
        }
    }

    @Override
    public Libro updateLibro(String id, String updateRequestString) {
        Libro libro = repositori.getById(Long.valueOf(id));
        if (libro != null) {
            try {
                JsonMergePatch jsonMergePatch = JsonMergePatch.fromJson(mapper.readTree(updateRequestString));
                JsonNode target = jsonMergePatch.apply(mapper.readTree(mapper.writeValueAsString(libro)));
                Libro patched = mapper.treeToValue(target, Libro.class);
                repositori.save(patched);
                return patched;
            } catch (JsonProcessingException | JsonPatchException e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
