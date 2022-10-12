package com.ege.account.dto;

import com.ege.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class    CustomerDtoConverter {
    private final CustomerAccountDtoConverter converter;

    public CustomerDtoConverter(CustomerAccountDtoConverter converter) {
        this.converter = converter;
    }

    public AccountCustomerDto convertToAccountCustomer(Customer customer){
         if(customer== null){
             return new AccountCustomerDto("","","");
         }
         return new AccountCustomerDto(customer.getId(),customer.getName(),customer.getSurname());
     }

     public CustomerDto convertToCustomerDto(Customer customer){
         return new CustomerDto(customer.getId(),
                 customer.getName(),
                 customer.getSurname(),
                 customer.getAccounts()
                         .stream()
                         .map(converter::convert)
                         .collect(Collectors.toSet()));
     }


}
