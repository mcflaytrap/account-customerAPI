package com.ege.account.dto;

import com.ege.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    public TransactionDto convert(Transaction transaction){
        return new TransactionDto(transaction.getId(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getTransactionDate());
    }
}
