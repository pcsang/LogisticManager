package com.express.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @Column(name = "order_id")
    private String id;
    @Column(name = "status_order")
    private String status;
    @Column(name = "price_order")
    private double price;
    @Column(name = "date_receipt")
    private Date dateOfReceipt;
    @Column(name = "description_order")
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "order_id")
    private Order order;
}
