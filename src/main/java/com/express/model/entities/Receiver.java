package com.express.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receiver")
public class Receiver {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String CompanyName;
    private String FullName;
    private String ContactName;
    private String postalCode;
    private String address1;
    private String address2;
    private String address3;
    private String phone;
    private String country;
    private String city;
    private String email;
    private String district;
    private String state;
    private String note;
    @OneToOne(mappedBy = "receivers")
    private Order order;
}
