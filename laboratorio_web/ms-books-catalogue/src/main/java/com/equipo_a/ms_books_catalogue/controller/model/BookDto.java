package com.equipo_a.ms_books_catalogue.controller.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookDto {

    private String titulo;
    private String autor;
    private String fecha;
    private String descripcion;
    private Double precio;
    private String isbn;
    private Integer valoracion;
    private String categoria;
    private String editorial;
    private Boolean visible;
}
