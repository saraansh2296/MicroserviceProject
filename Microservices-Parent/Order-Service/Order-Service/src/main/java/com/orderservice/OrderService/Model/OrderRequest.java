package com.orderservice.OrderService.Model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemsObject> orderLineItemsDtoList;
}