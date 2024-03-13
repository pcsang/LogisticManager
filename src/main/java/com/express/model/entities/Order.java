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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "shipper_id")
    private Shipper shippers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private Receiver receivers;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Packages> packages;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private Sender sender;

    private LocalDateTime sentDate;
    private String status;
    private String payStatus;
    private Integer numberOfPackage;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer( ).getPersistentClass( ) : o.getClass( );
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer( ).getPersistentClass( ) : this.getClass( );
        if (thisEffectiveClass != oEffectiveClass) return false;
        Order order = (Order) o;
        return getId( ) != null && Objects.equals(getId( ), order.getId( ));
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer( ).getPersistentClass( ).hashCode( ) : getClass( ).hashCode( );
    }
}
