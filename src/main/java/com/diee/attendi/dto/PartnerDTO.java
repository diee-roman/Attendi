package com.diee.attendi.dto;

import java.time.LocalDateTime;

public record PartnerDTO(Long id, String name, String email, LocalDateTime createdOn) {}
