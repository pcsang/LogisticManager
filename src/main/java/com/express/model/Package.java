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

}
