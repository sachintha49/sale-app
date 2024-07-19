package com.pos.point_of_sale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDto {
    private int itemId;

    private String itemName;

    private double balanceQty;

    private double supplierPrice;

    private double sellingPrice;

    private boolean isActive;
}
