package com.ege.account.service;

import com.ege.account.dto.CustomerDto;
import com.ege.account.dto.CustomerDtoConverter;
import com.ege.account.exception.CustomerNotFoundException;
import com.ege.account.model.Customer;
import com.ege.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    public Customer findCustomerById(String id){
        return customerRepository.findById(id).
                orElseThrow(
                        ()-> new CustomerNotFoundException("Customer not found by id "+id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));

    }
    public List<CustomerDto> getAllCustomer() {

        return customerRepository.findAll()
                .stream()
                .map(converter::convertToCustomerDto)
                .collect(Collectors.toList());
    }
}
