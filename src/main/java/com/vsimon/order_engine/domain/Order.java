package com.vsimon.order_engine.domain;

import java.util.Set;

public record Order(
    CustomerId customerId,
    Set<OrderLine> orderLines
    ) {

    public static Order create(CustomerId userId, Set<OrderLine> orderLines) {
        return new Order(userId, orderLines);
    }

}
