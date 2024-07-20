package com.pos.point_of_sale.service;

import com.pos.point_of_sale.dto.request.ItemSaveRequestDto;
import com.pos.point_of_sale.dto.response.ItemGetResponseDto;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDto itemSaveRequestDto);

    List<ItemGetResponseDto> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDto> getItemByNameAndStatusByMatStruct(String itemName);

    List<ItemGetResponseDto> getItemsByActiveStatus(boolean activeStatus);
}
