package com.express.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_employee")
public class UserEmployee {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "email")
    private String email;
    @Column(name = "name_employee")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private String gender;
    @Column(name = "role")
    private String role;
    @Column(name = "address_employee")
    private String address;
    @Column(name = "numbers_phone_employee")
    private String numbersPhone;
    @OneToMany(mappedBy = "userEmployees")
    private Set<Order> orderList;

    public void setId(String id) {
        this.id = id;
    }
}
