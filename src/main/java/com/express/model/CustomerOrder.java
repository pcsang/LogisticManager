package com.express.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_order")
public class CustomerOrder {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name_customer")
    private String nameCustomer;
    @Column(name = "numbers_phone_customer")
    private String numberPhoneCustomer;
    @Column(name = "email_customer")
    private String emailCustomer;
    @Column(name = "address_customer")
    private String addressCustomer;
    @OneToMany(mappedBy = "customerOrder")
    private Set<Order> orderSet;
}
