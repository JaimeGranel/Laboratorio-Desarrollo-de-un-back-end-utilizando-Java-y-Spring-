package com.equipo_a.ms_books_catalogue.Data.Model;

import com.equipo_a.ms_books_catalogue.controller.model.BookDto;
import com.equipo_a.ms_books_catalogue.Data.Utility.Consts;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = Consts.TITULO)
    private String titulo;

    @Column(name = Consts.AUTOR)
    private String autor;

    @Column(name = Consts.FECHA)
    private String fecha;

    @Column(name = Consts.DESCRIPCION)
    private String descripcion;

    @Column(name = Consts.PRECIO)
    private Double precio;

    @Column(name = Consts.ISBN)
    private String isbn;
    @Column(name = Consts.VALORACION)
    private Integer valoracion;

    @Column(name = Consts.CATEGORIA)
    private String categoria;

    @Column(name = Consts.EDITORIAL)
    private String editorial;

    @Column(name = Consts.VISIBLE)
    private Boolean visible;

    public  void  update(BookDto bookDto){

        this.titulo = bookDto.getTitulo();
        this.autor = bookDto.getAutor();
        this.fecha = bookDto.getFecha();
        this.descripcion = bookDto.getDescripcion();
        this.precio = bookDto.getPrecio();
        this.isbn = bookDto.getIsbn();
        this.valoracion = bookDto.getValoracion();
        this.categoria = bookDto.getCategoria();
        this.editorial = bookDto.getEditorial();
        this.visible = bookDto.getVisible();
    }

}
