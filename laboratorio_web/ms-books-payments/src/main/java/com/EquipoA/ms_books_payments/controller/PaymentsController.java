package com.EquipoA.ms_books_payments.controller;

import com.EquipoA.ms_books_payments.controller.model.PaymentRequest;
import com.EquipoA.ms_books_payments.data.model.Payment;
import com.EquipoA.ms_books_payments.service.IPaymentsService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PaymentsController {

    private final IPaymentsService service;

    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestBody @Valid PaymentRequest request) {

        log.info("Creating payment...");
        Payment created = service.createPayment(request);

        if (created == null) { return ResponseEntity.badRequest().build(); }
        else { return ResponseEntity.ok().body(created); }
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {

        List<Payment> payments = service.getAllPayments();

        if (payments == null) { return ResponseEntity.ok(Collections.emptyList()); }
        else { return ResponseEntity.ok(payments); }
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String id) {

        Payment payment = service.getPaymentById(id);

        if (payment == null) { return ResponseEntity.notFound().build(); }
        else { return ResponseEntity.ok(payment); }
    }
}
