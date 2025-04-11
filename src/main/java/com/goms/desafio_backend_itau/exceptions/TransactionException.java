package com.goms.desafio_backend_itau.exceptions;

import com.goms.desafio_backend_itau.model.Transaction;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionException extends RuntimeException {
    public TransactionException(String message) {
        super(message);
    }
}