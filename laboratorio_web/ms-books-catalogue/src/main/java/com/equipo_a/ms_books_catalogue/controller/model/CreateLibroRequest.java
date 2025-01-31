package com.equipo_a.ms_books_catalogue.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLibroRequest {

    private String titulo;
    private String autor;
    private String fecha;
    private String descripcion;
    private Double precio;
    private String isbn;
    private int valoracion;
    private String categoria;
    private String editorial;
    private Boolean visible;
}
