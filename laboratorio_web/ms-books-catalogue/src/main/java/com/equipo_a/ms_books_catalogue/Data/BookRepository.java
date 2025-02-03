package com.equipo_a.ms_books_catalogue.Data;

import com.equipo_a.ms_books_catalogue.Data.Model.Book;
import com.equipo_a.ms_books_catalogue.Data.Utility.SearchCriteria;
import com.equipo_a.ms_books_catalogue.Data.Utility.SearchStatement;
import com.equipo_a.ms_books_catalogue.Data.Utility.SearchOperation;
import com.equipo_a.ms_books_catalogue.Data.Utility.Consts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.StringUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final BookJpaRepository repository;

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Book save(Book book) { return repository.save(book);}

    public void delete(Book book) { repository.delete(book);}

    public List<Book> search(String titulo, String autor, String fecha, String descripcion, Double precio , String isbn, Integer valoracion, String categoria, String editorial, Boolean visible) {
        SearchCriteria<Book> spec = new SearchCriteria<>();

        if (StringUtils.isNotBlank(titulo)) {
            spec.addSearchStatement(new SearchStatement(Consts.TITULO, titulo, SearchOperation.MATCH));
        }

        if (StringUtils.isNotBlank(autor)) {
            spec.addSearchStatement(new SearchStatement(Consts.AUTOR, autor, SearchOperation.MATCH));
        }

        if (StringUtils.isNotBlank(fecha)) {
            spec.addSearchStatement(new SearchStatement(Consts.FECHA, fecha, SearchOperation.EQUAL));
        }

        if (StringUtils.isNotBlank(descripcion)) {
            spec.addSearchStatement(new SearchStatement(Consts.DESCRIPCION, descripcion, SearchOperation.MATCH));
        }

        if(precio!=null){
            spec.addSearchStatement(new SearchStatement(Consts.PRECIO, precio, SearchOperation.MATCH));
        }
        if(StringUtils.isNotBlank(isbn)){
            spec.addSearchStatement(new SearchStatement(Consts.ISBN, isbn, SearchOperation.EQUAL));
        }
        if(valoracion!=null){
            spec.addSearchStatement(new SearchStatement(Consts.VALORACION, valoracion, SearchOperation.EQUAL));
        }
        if(StringUtils.isNotBlank(categoria)){
            spec.addSearchStatement(new SearchStatement(Consts.CATEGORIA, categoria, SearchOperation.EQUAL));
        }
        if(StringUtils.isNotBlank(editorial)){
            spec.addSearchStatement(new SearchStatement(Consts.EDITORIAL, editorial, SearchOperation.MATCH));
        }
        if (visible != null) {
            spec.addSearchStatement(new SearchStatement(Consts.VISIBLE, visible, SearchOperation.EQUAL));
        }

        return repository.findAll(spec);
    }

}
