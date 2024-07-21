package com.pos.point_of_sale.dto.request;

import com.pos.point_of_sale.entity.Item;
import com.pos.point_of_sale.entity.Order;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private int order;
}
