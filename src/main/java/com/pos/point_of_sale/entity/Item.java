package com.pos.point_of_sale.entity;

import com.pos.point_of_sale.entity.enums.MeasuringUnitType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "item")
@Schema(description = "Item entity")
public class Item {
    @Id
    @Column(name = "item_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Unique Identified of the Item", example = "1")
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    @Schema(description = "Name of the Item", example = "LCD Monitor")
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type", length = 100, nullable = false)
    @Schema(description = "Name of the Item", example = "KILO")
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty", length = 100, nullable = false)
    @Schema(description = "Name of the Item")
    private double balanceQty;

    @Column(name = "supplier_price", length = 100, nullable = false)
    @Schema(description = "Supplier Price")
    private double supplierPrice;

    //this means unit price
    @Column(name = "selling_price", length = 100, nullable = false)
    @Schema(description = "Selling Price")
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    @Schema(description = "Customer availablitiy", example = "true")
    private boolean isActive;

    //meka mehema dammama table eke mokuth hedenne nehe just reference eka witharai hedenne.
    // eka item ekak order details keepayaka thiyenna puluwan but orderDetail ekaka thiyenen eka item ekai.
    @OneToMany(mappedBy = "items")
    private Set<OrderDetails> orderDetails;
}
