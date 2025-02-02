package com.EquipoA.ms_books_payments.controller.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    @NotNull(message = "`books` cannot be null")
    @NotEmpty(message = "`books` cannot be epmty")
    private List<String> books;
}
