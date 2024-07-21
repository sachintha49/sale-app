package com.pos.point_of_sale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RequestOrderDetailSave {
    private String itemName;

    private double qty;

    private double amount;

    private int items;

    /*order ID to track the order related to items*/
    private int order;
}
