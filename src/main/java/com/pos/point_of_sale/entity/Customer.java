package com.pos.point_of_sale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 255)
    private String customerAddress;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "salary")
    private double customerSalary;

    @Column(name = "nic")
    private String nic;

    @Column(name = "state", columnDefinition = "TINYINT default 0")
    private boolean isActive = true;
}
