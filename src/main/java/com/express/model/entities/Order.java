package com.express.model.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

import java.sql.Date;
import java.util.List;

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
    @JoinColumn(name = "shipper_id")
    private Shipper shippers;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private Receiver receivers;
    @OneToMany(mappedBy = "orders")
    private List<Packages> packages;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Sender sender;

    private Date sentDate;
    private String status;
    private String payStatus;
    private Integer numberOfPackage;

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Receiver getReceiver() {
        return receivers;
    }

    public void setReceiver(Receiver receiver) {
        this.receivers = receiver;
    }

    public Shipper getShipper() {
        return shippers;
    }

    public void setShipper(Shipper shipper) {
        this.shippers = shipper;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Packages> getPackages() {
        return packages;
    }

    public void setPackages(List<Packages> packages) {
        this.packages = packages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public int getNumberOfPackage() {
        return numberOfPackage;
    }

    public void setNumberOfPackage(int numberOfPackage) {
        this.numberOfPackage = numberOfPackage;
    }

    public Shipper getShippers() {
        return shippers;
    }

    public void setShippers(Shipper shippers) {
        this.shippers = shippers;
    }

    public Receiver getReceivers() {
        return receivers;
    }

    public void setReceivers(Receiver receivers) {
        this.receivers = receivers;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public void setNumberOfPackage(Integer numberOfPackage) {
        this.numberOfPackage = numberOfPackage;
    }
}
