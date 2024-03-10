package com.express.model.entities;

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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccount(List<Account> accounts) {
        this.accounts = accounts;
    }

    public ShipperDetails getDetails() {
        return details;
    }

    public void setDetails(ShipperDetails details) {
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<Partner> getPartners() {
        return partners;
    }

    public void setPartners(List<Partner> partners) {
        this.partners = partners;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
