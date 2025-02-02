package com.EquipoA.ms_books_payments.service;

import com.EquipoA.ms_books_payments.data.IPaymentJpaRepository;
import com.EquipoA.ms_books_payments.data.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.EquipoA.ms_books_payments.facade.BooksFacade;
import com.EquipoA.ms_books_payments.facade.model.Book;
import com.EquipoA.ms_books_payments.controller.model.PaymentRequest;

@Service
@RequiredArgsConstructor
public class PaymentsService implements IPaymentsService {

    private final BooksFacade booksFacade;
    private final IPaymentJpaRepository repository;

    @Override
    public Payment createPayment(PaymentRequest request) {

        List<Book> books = request.getBooks().stream().map(booksFacade::getBook).filter(Objects::nonNull).toList();

        if (books.size() != request.getBooks().size() || books.stream().anyMatch(book -> !book.getVisible())) {
            return null;
        }
        else {
           Payment payment = Payment.builder().books(books.stream().map(Book::getId).collect(Collectors.toList())).build();
           repository.save(payment);
           return payment;
        }
    }

    @Override
    public Payment getPaymentById(String id) {
        return repository.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        List<Payment> payments = repository.findAll();
        return payments.isEmpty() ? null : payments;
    }
}
