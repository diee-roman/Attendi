package com.diee.attendi.repository;

import com.diee.attendi.model.Customer;
import com.diee.attendi.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByNameEqualsIgnoreCaseAndPartner(String name, Partner partner);

    List<Customer> findCustomerByPartner(Partner partner);
}
