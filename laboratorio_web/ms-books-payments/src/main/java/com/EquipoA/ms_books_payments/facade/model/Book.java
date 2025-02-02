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
    // TODO based on model provided by jaime
    private Long id;
    private String title;
    private String author;
    private String description;
    private Double price;
    private Boolean visible;
}
