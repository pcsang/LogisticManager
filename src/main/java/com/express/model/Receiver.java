package com.express.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receiver")
public class Receiver {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name_receiver")
    private String nameReceiver;
    @Column(name = "address_receiver")
    private String addressReceiver;
    @Column(name = "numbers_phone_receiver")
    private String numbersPhoneReceiver;
}
