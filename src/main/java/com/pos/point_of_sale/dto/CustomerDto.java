package com.pos.point_of_sale.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDto {
    private int customerId;

    private String customerName;

    private String customerAddress;

    private double customerSalary;

    private String contactNumber;

    private String nic;

    private boolean isActive;
}
