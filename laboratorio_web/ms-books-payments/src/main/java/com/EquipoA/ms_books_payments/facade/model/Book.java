package com.EquipoA.ms_books_payments.facade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Long id;
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
