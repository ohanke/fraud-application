package com.oscarhanke.customer.service;

import com.oscarhanke.clients.fraud.FraudCheckResponse;
import com.oscarhanke.clients.fraud.FraudClient;
import com.oscarhanke.customer.model.Customer;
import com.oscarhanke.customer.model.CustomerRegistrationRequest;
import com.oscarhanke.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate, FraudClient fraudClient) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //todo: check if email is valid
        //todo: check if email is not taken
        customerRepository.saveAndFlush(customer);
        //todo: check if fraudster

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }

        //todo: send notification
    }
}
