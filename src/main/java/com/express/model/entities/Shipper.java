package com.express.model.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import java.util.List;

@Data
@Builder
@Entity
@Table(name = "shipper")
public class Shipper {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roles;

    @OneToOne(mappedBy = "shippers", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ShipperDetails details;

    @OneToMany(mappedBy = "shippers")
    private List<Account> accounts;

    @OneToMany(mappedBy = "shippers")
    private List<Partner> partners;

    @OneToMany(mappedBy = "shippers")
    private List<Order> orders;

}
