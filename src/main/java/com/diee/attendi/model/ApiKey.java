package com.diee.attendi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "api_key")
@Data
public class ApiKey {

    @Id
    @SequenceGenerator(name="api_key_id_seq", sequenceName="api_key_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="api_key_id_seq")
    private Long id;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdOn;
    private String key;
    private Boolean active;

    @ManyToOne
    private Customer customer;

    public ApiKey() {
    }

    public ApiKey(String key, Boolean active, Customer customer) {
        this.key = key;
        this.active = active;
        this.customer = customer;
    }
}
