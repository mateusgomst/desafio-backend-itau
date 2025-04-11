package com.goms.desafio_backend_itau.model;

import java.time.OffsetDateTime;

public class Transaction {
    private final Double amount;
    private final OffsetDateTime date;

    public Transaction(Double amount, OffsetDateTime date) {
        this.amount = amount;
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public OffsetDateTime getDate() {
        return date;
    }
}
