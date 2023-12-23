package com.orderservice.OrderService.Model;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsObject {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
