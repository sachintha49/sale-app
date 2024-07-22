package com.pos.point_of_sale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseOrderDetailsDto {
    //customer
    private String customerName;

    private String customerAddress;

    private String contactNumber;

    //order
    private Date date;

    private Double total;
}
