package com.express.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "delivery_service")
public class DeliveryService {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name_delivery")
    private String name;
    @Column(name = "website")
    private String website;
}
