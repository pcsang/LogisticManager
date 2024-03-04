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
@Table(name = "package_details")
public class PackageDetails {
    @Id
    @Column(name = "package_id")
    private String id;
    @Column(name = "status_package")
    private String status;
    @Column(name = "date_receipt")
    private Date dateOfReceipt;
    @Column(name = "description_package")
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "package_id")
    private Package packages;
}
