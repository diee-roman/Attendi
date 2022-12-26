package com.diee.attendi.service;

import com.diee.attendi.dto.PartnerDTO;
import com.diee.attendi.model.Partner;
import com.diee.attendi.repository.PartnerRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerService {

    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public List<PartnerDTO> getAllPartners() {
        return this.partnerRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private PartnerDTO toDto(Partner partner) {
        return new PartnerDTO(partner.getId(), partner.getName(), partner.getEmail(), partner.getCreatedOn());
    }

    public PartnerDTO createPartner(PartnerDTO partner) {
        if (this.partnerRepository.findByEmailEqualsIgnoreCase(partner.email()).isPresent()) {
            throw new EntityExistsException("The partner you are trying to create already exists.");
        }

        var savedPartner = this.partnerRepository.saveAndFlush(new Partner(partner.name(), partner.email(), true));
        return new PartnerDTO(savedPartner.getId(), savedPartner.getName(), savedPartner.getEmail(), savedPartner.getCreatedOn());
    }
}
