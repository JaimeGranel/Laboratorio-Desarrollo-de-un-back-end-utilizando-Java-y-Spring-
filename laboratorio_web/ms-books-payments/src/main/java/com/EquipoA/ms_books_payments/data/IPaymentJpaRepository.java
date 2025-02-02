package com.EquipoA.ms_books_payments.data;

import com.EquipoA.ms_books_payments.data.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentJpaRepository extends JpaRepository<Payment, Long> {
}
