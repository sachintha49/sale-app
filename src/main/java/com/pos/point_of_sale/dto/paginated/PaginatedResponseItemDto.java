package com.pos.point_of_sale.dto.paginated;

import com.pos.point_of_sale.dto.response.ItemGetResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDto {
    private List<ItemGetResponseDto> list;
    private long dataCount;
}
