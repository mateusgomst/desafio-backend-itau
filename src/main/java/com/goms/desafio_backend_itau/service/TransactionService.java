package com.goms.desafio_backend_itau.service;

import com.goms.desafio_backend_itau.exceptions.TransactionException;
import com.goms.desafio_backend_itau.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        validateTransaction(transaction);
        transactions.add(transaction);
    }

    private void validateTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
        if (transaction.getAmount() == null || transaction.getDate() == null) {
            throw new IllegalArgumentException("Transaction amount and date cannot be null");
        }
        if (transaction.getAmount() < 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than zero");
        }
        if (transaction.getDate().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Transaction date cannot be in the future");
        }
    }
}
