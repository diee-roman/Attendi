package com.diee.attendi.repository;

import com.diee.attendi.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    Optional<Partner> findByEmailEqualsIgnoreCase(String email);
}
