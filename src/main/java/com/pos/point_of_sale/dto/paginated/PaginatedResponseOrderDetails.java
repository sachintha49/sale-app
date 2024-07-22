package com.pos.point_of_sale.dto.paginated;

import com.pos.point_of_sale.dto.response.ResponseOrderDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetails {
    private List<ResponseOrderDetailsDto> list;
    private long dataCount;
}
