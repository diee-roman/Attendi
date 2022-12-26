package com.diee.attendi.controller;

import com.diee.attendi.dto.CreateCustomerDTO;
import com.diee.attendi.dto.CustomerDTO;
import com.diee.attendi.dto.PartnerDTO;
import com.diee.attendi.service.CustomerService;
import com.diee.attendi.service.PartnerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partners")
public class PartnerController {

    private final PartnerService partnerService;
    private final CustomerService customerService;

    public PartnerController(PartnerService partnerService, CustomerService customerService) {this.partnerService = partnerService;
        this.customerService = customerService;
    }

    @GetMapping()
    public List<PartnerDTO> getPartners() {
        return this.partnerService.getAllPartners();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PartnerDTO createPartner(@RequestBody PartnerDTO partner) {
        return this.partnerService.createPartner(partner);
    }

    @GetMapping(value = "/{id}/customers")
    public List<CustomerDTO> getCustomers(@PathVariable("id") Long id) {
        return this.customerService.getCustomersByPartner(id);
    }

    @PostMapping(value = "/{id}/customers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO createPartner(@PathVariable("id") Long id, @RequestBody CreateCustomerDTO customer) {
        return this.customerService.createCustomer(customer, id);
    }
}
