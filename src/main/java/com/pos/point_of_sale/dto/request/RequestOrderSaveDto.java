package com.pos.point_of_sale.dto.request;

import com.pos.point_of_sale.entity.Customer;
import com.pos.point_of_sale.entity.OrderDetails;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RequestOrderSaveDto {
    private int customer;

    private Date date;

    private Double total;

    private List<RequestOrderDetailSave> orderDetails;
}
