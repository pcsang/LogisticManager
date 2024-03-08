package com.express.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "shipper")
public class Shipper {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String roles;

    @OneToOne(mappedBy = "shippers", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ShipperDetails details;

    @OneToOne(mappedBy = "shippers", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ShipperDetails getDetails() {
        return details;
    }

    public void setDetails(ShipperDetails details) {
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
