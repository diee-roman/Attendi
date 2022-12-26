package com.diee.attendi.service;

import com.diee.attendi.dto.CreateCustomerDTO;
import com.diee.attendi.dto.CustomerDTO;
import com.diee.attendi.model.ApiKey;
import com.diee.attendi.model.Customer;
import com.diee.attendi.model.Partner;
import com.diee.attendi.repository.CustomerRepository;
import com.diee.attendi.repository.PartnerRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PartnerRepository partnerRepository;
    private final ApiKeyService apiKeyService;

    public CustomerService(CustomerRepository customerRepository, PartnerRepository partnerRepository, ApiKeyService apiKeyService) {this.customerRepository = customerRepository;
        this.partnerRepository = partnerRepository;
        this.apiKeyService = apiKeyService;
    }

    public List<CustomerDTO> getAllPartners() {
        return this.customerRepository.findAll().stream().map(customer -> this.toDto(customer, customer.getLastestApiKey())).collect(Collectors.toList());
    }

    public CustomerDTO createCustomer(CreateCustomerDTO customer, Long partnerId) {
        var partner = this.partnerExists(partnerId);

        if (this.customerRepository.findByNameEqualsIgnoreCaseAndPartner(customer.name(), partner).isPresent()) {
            throw new EntityExistsException("The customer you are trying to create already exists.");
        }
        var generatedApiKey = this.apiKeyService.generateRandomKey();
        var customerToSave = new Customer(customer.name(), true, partner);
        var apiKey = new ApiKey(generatedApiKey, true, customerToSave);
        customerToSave.setApiKeys(List.of(apiKey));

        var savedCustomer = this.customerRepository.saveAndFlush(customerToSave);
        return toDto(savedCustomer, apiKey);
    }

    public List<CustomerDTO> getCustomersByPartner(Long id) {
        var partner = partnerExists(id);
        return this.customerRepository.findCustomerByPartner(partner).stream().map(customer -> this.toDto(customer, customer.getLastestApiKey())).collect(Collectors.toList());
    }

    public Partner partnerExists(Long partnerId) {
        var partner = this.partnerRepository.findById(partnerId);
        return partner.orElseThrow(
            () -> new EntityNotFoundException("The partner does not exist")
        );
    }

    private CustomerDTO toDto(Customer customer, ApiKey apiKey) {
        return new CustomerDTO(customer.getId(), customer.getName(), apiKey.getKey());
    }
}
