package com.goms.desafio_backend_itau.service;

import com.goms.desafio_backend_itau.exceptions.TransactionException;
import com.goms.desafio_backend_itau.model.Statistics;
import com.goms.desafio_backend_itau.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        validateTransaction(transaction);
        transactions.add(transaction);
    }

    public void clearTransactions() {
        transactions.clear();
    }

    public Statistics getStatistics(long seconds) {
        OffsetDateTime cutoffTime = OffsetDateTime.now().minusSeconds(seconds);

        List<Transaction> recentTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getDate().isAfter(cutoffTime) || transaction.getDate().equals(cutoffTime)) {
                recentTransactions.add(transaction);
            }
        }
        return new Statistics(recentTransactions);
    }

    private void validateTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new TransactionException("Transaction cannot be null");
        }
        if (transaction.getAmount() == null || transaction.getDate() == null) {
            throw new TransactionException("Transaction amount and date cannot be null");
        }
        if (transaction.getAmount() < 0) {
            throw new TransactionException("Transaction amount must be greater than zero");
        }
        if (transaction.getDate().isAfter(OffsetDateTime.now())) {
            throw new TransactionException("Transaction date cannot be in the future");
        }
    }
}
