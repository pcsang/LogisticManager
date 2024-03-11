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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "partner")
public class Partner {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String CompanyName;
    private String name;
    private String ContactName;
    private String address1;
    private String address2;
    private String phone;
    private String country;
    private String city;
    private String email;
    private String district;
    private String state;
    private String note;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shippers;

}
