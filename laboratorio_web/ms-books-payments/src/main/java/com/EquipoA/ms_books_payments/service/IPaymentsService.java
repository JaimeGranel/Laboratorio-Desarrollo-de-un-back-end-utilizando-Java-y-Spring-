package com.EquipoA.ms_books_payments.service;

import com.EquipoA.ms_books_payments.data.model.Payment;
import com.EquipoA.ms_books_payments.controller.model.PaymentRequest;
import java.util.List;

public interface IPaymentsService {

    Payment createPayment(PaymentRequest request);

    Payment getPaymentById(String id);

    List<Payment> getAllPayments();
}
