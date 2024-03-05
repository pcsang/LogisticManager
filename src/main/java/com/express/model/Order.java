package com.express.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name_order")
    private String nameOrder;
    @Column(name = "type_order")
    private String typeOrder;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private OrderDetails orderDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "order_package",
    joinColumns =
            {@JoinColumn(name = "order_id",referencedColumnName = "id")},
    inverseJoinColumns =
            {@JoinColumn(name = "package_id", referencedColumnName = "id")})
    private Package packages;


    @ManyToOne
    @JoinColumn(name = "user_employees_id")
    private UserEmployee userEmployees;


    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;
}
