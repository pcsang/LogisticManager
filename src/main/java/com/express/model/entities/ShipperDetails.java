package com.express.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shipper_details")
public class ShipperDetails {
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

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "shipper_id", referencedColumnName = "id")
    private Shipper shipper;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer( ).getPersistentClass( ) : o.getClass( );
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer( ).getPersistentClass( ) : this.getClass( );
        if (thisEffectiveClass != oEffectiveClass) return false;
        ShipperDetails that = (ShipperDetails) o;
        return getId( ) != null && Objects.equals(getId( ), that.getId( ));
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer( ).getPersistentClass( ).hashCode( ) : getClass( ).hashCode( );
    }
}
