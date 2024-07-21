package com.pos.point_of_sale.service;

import com.pos.point_of_sale.dto.request.RequestOrderSaveDto;

public interface OrderService {
    String addOrder(RequestOrderSaveDto itemSaveRequestDto);
}
