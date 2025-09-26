package com.vsimon.order_engine.domain;

import java.util.Set;

public record Order(
    OrderId orderId,
    CustomerId customerId,
    Set<OrderLine> orderLines
    ) {

    public static Order create(OrderId orderId, CustomerId userId, Set<OrderLine> orderLines) {
        return new Order(orderId, userId, orderLines);
    }

}
