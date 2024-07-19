package com.pos.point_of_sale.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "customer")
@Schema(description = "User entity")
@Builder
public class Customer {
    @Id
    @Column(name = "customer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Unique Identified of the Customer", example = "1")
    private int customerId;

    @Column(name = "customer_name", nullable = false)
    @Schema(description = "Name of the Customer", example = "Sachintha")
    private String customerName;

    @Column(name = "customer_address", length = 255)
    @Schema(description = "Address of the Customer", example = "Kottawa")
    private String customerAddress;

    @Column(name = "contact_number")
    @Schema(description = "Mobile of the Customer", example = "0778787332")
    private String contactNumber;

    @Column(name = "salary")
    @Schema(description = "Salary of the Customer", example = "250,000.00")
    private double customerSalary;

    @Column(name = "nic")
    @Schema(description = "Unique Identified of the Customer", example = "1889837383v")
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    @Schema(description = "Customer availablitiy", example = "true")
    private boolean isActive;
}
