package com.pos.point_of_sale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerUpdateDto {
    private int customerId;

    private String customerName;

    private String customerAddress;

    private double customerSalary;
}
