package com.diee.attendi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @SequenceGenerator(name="customer_id_seq", sequenceName="customer_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customer_id_seq")
    private Long id;
    private String name;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdOn;

    @OneToMany(mappedBy = "customer")
    private List<ApiKey> apiKeys;

    private Boolean active;
    @ManyToOne
    private Partner partner;

    public Customer() {
    }

    public Customer(String name, Boolean active, Partner partner) {
        this.name = name;
        this.active = active;
        this.partner = partner;
    }

    public ApiKey getLastestApiKey() {
        return this.apiKeys.stream().max(Comparator.comparing(ApiKey::getCreatedOn)).get();
    }
}
