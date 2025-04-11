package com.goms.desafio_backend_itau.model;

import java.time.OffsetDateTime;

public class Transaction {
    private final Double valor;
    private final OffsetDateTime dataHora;

    public Transaction(Double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Double getAmount() {
        return valor;
    }

    public OffsetDateTime getDate() {
        return dataHora;
    }
}
