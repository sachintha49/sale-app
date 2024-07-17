package com.pos.point_of_sale.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import java.util.ArrayList;

@Entity
@Table(name = "customer")
public class Customer {
    public Customer(){

    }

    public Customer(int customerId, String customerName, String customerAddress, String contactNumber, String nic, boolean isActive) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.isActive = isActive;
    }

    @Id
    @Column(name = "customer_id", length = 45)
    private int customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 255)
    private String customerAddress;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "nic")
    private String nic;

    @Column(name = "state", columnDefinition = "TINYINT default 0")
    private boolean isActive = true;
}
