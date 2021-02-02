package com.salom.vasalim.web.rest;

import com.salom.vasalim.demain.Transaction;
import com.salom.vasalim.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionResource {

    private final TransactionService transactionService;

    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public ResponseEntity getMsg(){
        return ResponseEntity.ok(transactionService.getAll());
    }

    @PostMapping("/transactions")
    public ResponseEntity creat(@RequestBody Transaction transaction){
        return ResponseEntity.ok(transactionService.saveExch(transaction));
    }
    @PutMapping("/transactions")
    public ResponseEntity update(@RequestBody Transaction transaction){
        return ResponseEntity.ok(transactionService.update(transaction));
    }
}
