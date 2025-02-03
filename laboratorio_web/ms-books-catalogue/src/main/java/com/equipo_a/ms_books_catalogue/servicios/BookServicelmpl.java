package com.equipo_a.ms_books_catalogue.servicios;

import com.equipo_a.ms_books_catalogue.Data.BookRepository;
import com.equipo_a.ms_books_catalogue.Data.Model.Book;
import com.equipo_a.ms_books_catalogue.controller.model.CreateBookRequest;
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
public class BookServicelmpl implements BookService {


    private final BookRepository repository;

    private final ObjectMapper mapper;

    @Override
    public List<Book> getBooks(String titulo, String autor, String fecha, String descripcion, Double precio, String isbn, Integer valoracion, String categoria, String editorial, Boolean visible) {
        if(StringUtils.hasLength(titulo) || StringUtils.hasLength(autor) || StringUtils.hasLength(fecha) ||
                StringUtils.hasLength(descripcion) || precio != null || StringUtils.hasLength(isbn) ||
                valoracion !=null || StringUtils.hasLength(categoria) || StringUtils.hasLength(editorial) || visible != null){
            return repository.search(titulo,autor,fecha,descripcion,precio,isbn,valoracion,categoria,editorial,visible);
        }
        List<Book> books = repository.getBooks();
        return books.isEmpty() ? null : books;
    }

    @Override
    public Book getBook(String id) {
        return repository.getById(Long.valueOf(id));
    }

    @Override
    public Boolean removeBook(String id) {

        Book product = repository.getById(Long.valueOf(id));

        if (product != null) {
            repository.delete(product);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Book addBook(CreateBookRequest request) {
        if (request != null && StringUtils.hasLength(request.getTitulo().trim())
                && StringUtils.hasLength(request.getAutor().trim())
                && StringUtils.hasLength(request.getFecha().trim())
                && StringUtils.hasLength(request.getDescripcion().trim())
                && request.getPrecio() != null
                && StringUtils.hasLength(request.getIsbn().trim())
                && request.getValoracion() !=null
                && StringUtils.hasLength(request.getCategoria().trim())
                && StringUtils.hasLength(request.getEditorial().trim())
                && request.getVisible() != null) {


            Book book = Book.builder()
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


            return repository.save(book);
        } else {
            return null;
        }
    }

    @Override
    public Book updateBook(String id, LibroDto updateRequest) {
        Book book = repository.getById(Long.valueOf(id));
        if (book != null) {
            book.update(updateRequest);
            repository.save(book);
            return book;
        } else {
            return null;
        }
    }

    @Override
    public Book updateBook(String id, String updateRequestString) {
        Book book = repository.getById(Long.valueOf(id));
        if (book != null) {
            try {
                JsonMergePatch jsonMergePatch = JsonMergePatch.fromJson(mapper.readTree(updateRequestString));
                JsonNode target = jsonMergePatch.apply(mapper.readTree(mapper.writeValueAsString(book)));
                Book patched = mapper.treeToValue(target, Book.class);
                repository.save(patched);
                return patched;
            } catch (JsonProcessingException | JsonPatchException e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
