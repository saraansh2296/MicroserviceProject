package com.orderservice.OrderService.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.orderservice.OrderService.Model.Order;
import com.orderservice.OrderService.Model.OrderLineItems;
import com.orderservice.OrderService.Model.OrderLineItemsObject;
import com.orderservice.OrderService.Model.OrderRequest;
import com.orderservice.OrderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToOrderLineItemsObject)
                .toList();
        order.setOrderLineItemsList(orderLineItems);
        repository.save(order);

        return order;

    }

    private OrderLineItems mapToOrderLineItemsObject(OrderLineItemsObject orderLineItemsObject) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(orderLineItemsObject.getId());
        orderLineItems.setQuantity(orderLineItemsObject.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsObject.getSkuCode());
        orderLineItems.setPrice(orderLineItemsObject.getPrice());

        return orderLineItems;
    }


    public List<Order> getAllOrders(){
        return repository.findAll();
    }


}
