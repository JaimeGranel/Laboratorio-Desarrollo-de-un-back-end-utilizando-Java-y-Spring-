package com.equipo_a.ms_books_catalogue.Data.Model;

import com.equipo_a.ms_books_catalogue.controller.model.LibroDto;
import jakarta.persistence.*;
import lombok.*;
import com.equipo_a.ms_books_catalogue.Data.Utility.Consts;


@Entity
@Table(name="Libros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Libro
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
    private int valoracion;

    @Column(name = Consts.CATEGORIA)
    private String categoria;

    @Column(name = Consts.EDITORIAL)
    private String editorial;

    @Column(name = Consts.VISIBLE)
    private Boolean visible;

    public  void  update(LibroDto libroDto){

        this.titulo = libroDto.getTitulo();
        this.autor = libroDto.getAutor();
        this.fecha = libroDto.getFecha();
        this.descripcion = libroDto.getDescripcion();
        this.precio = libroDto.getPrecio();
        this.isbn = libroDto.getIsbn();
        this.valoracion = libroDto.getValoracion();
        this.categoria = libroDto.getCategoria();
        this.editorial = libroDto.getEditorial();
        this.visible = libroDto.getVisible();
    }

}
