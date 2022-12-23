package com.diee.attendi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "partner")
@Data
public class Partner {
    @Id
    @SequenceGenerator(name="partner_id_seq", sequenceName="partner_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="partner_id_seq")
    private Long id;
    private String name;
    private String email;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdOn;
    private Boolean active;
    @OneToMany(mappedBy = "partner")
    private List<Customer> customers;

    public Partner() {
    }

    public Partner(String name, String email, Boolean active) {
        this.name = name;
        this.email = email;
        this.active = active;
    }
}
