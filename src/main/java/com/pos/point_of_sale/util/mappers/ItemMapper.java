package com.pos.point_of_sale.util.mappers;

import com.pos.point_of_sale.dto.paginated.PaginatedResponseItemDto;
import com.pos.point_of_sale.dto.response.ItemGetResponseDto;
import com.pos.point_of_sale.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    /*convert karaganna one type eka abstract ekak vidiyata hadanawa. argument ekata danne api laga badu thiyana eka*/
    List<ItemGetResponseDto> entityListToDtoList(List<Item> items);

    List<ItemGetResponseDto> listDtoToPage(Page<Item> items);
}
