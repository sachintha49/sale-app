package com.pos.point_of_sale.dto.request;

import com.pos.point_of_sale.entity.enums.MeasuringUnitType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ItemSaveRequestDto {

    private String itemName;

    private MeasuringUnitType measuringUnitType;

    private double balanceQty;

    private double supplierPrice;

    private double sellingPrice;
}
