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
import javax.persistence.JoinColumns;
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
@Table(name = "package")
public class Package {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name_package")
    private String name;

    @OneToOne(mappedBy = "packages", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PackageDetails packageDetails;

    @OneToOne(mappedBy = "packages")
    private Order order;

    @ManyToOne
    @JoinTable(name = "order_package",
    joinColumns =
            {@JoinColumn(name = "package_id", referencedColumnName = "id")},
    inverseJoinColumns =
            {@JoinColumn(name = "delivery_service_id", referencedColumnName = "id")})
    private DeliveryService deliveryService;

}
