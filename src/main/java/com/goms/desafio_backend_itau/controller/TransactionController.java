package com.goms.desafio_backend_itau.controller;

import com.goms.desafio_backend_itau.model.Statistics;
import com.goms.desafio_backend_itau.model.Transaction;
import com.goms.desafio_backend_itau.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transacao")
    public ResponseEntity<?> transaction(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<?> clearTransactions() {
        transactionService.clearTransactions();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<Statistics> getStatistics(@RequestParam long seconds) {
        return ResponseEntity.ok(transactionService.getStatistics(seconds));
    }


}
