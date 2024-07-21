package com.pos.point_of_sale.entity;

import com.pos.point_of_sale.entity.enums.MeasuringUnitType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "orders")
@Schema(description = "Orders entity")
public class Order {
    @Id
    @Column(name = "order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    // meka hedenne customerge primary key ekata anuwa. Customer object eka dala thibbata
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total", nullable = false)
    private Double total;

    // anith table eka map karaganne MappedBy kiyana eken.
    @OneToMany(mappedBy = "order")
    private Set<OrderDetails> orderDetails;

}
