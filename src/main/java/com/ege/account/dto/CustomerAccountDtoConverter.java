package com.ege.account.dto;

import com.ege.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter converter;

    public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.converter = transactionDtoConverter;
    }

    public CustomerAccountDto convert(Account account){
        return new  CustomerAccountDto(account.getId(),
                Objects.requireNonNull(account.getBalance()),
                account.getTransaction().stream().map(converter::convert).collect(Collectors.toSet()),
                account.getCreationTime());
    }
}
