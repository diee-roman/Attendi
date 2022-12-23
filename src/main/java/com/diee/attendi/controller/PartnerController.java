package com.diee.attendi.controller;

import com.diee.attendi.dto.PartnerDTO;
import com.diee.attendi.service.PartnerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partners")
public class PartnerController {

    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {this.partnerService = partnerService;}

    @GetMapping()
    public List<PartnerDTO> getPartners() {
        return this.partnerService.getAllPartners();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PartnerDTO createPartner(@RequestBody PartnerDTO partner) {
        return this.partnerService.createPartner(partner);
    }
}
