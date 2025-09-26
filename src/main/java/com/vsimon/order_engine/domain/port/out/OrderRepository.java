package com.vsimon.order_engine.domain.port.out;

import com.vsimon.order_engine.domain.Order;
import com.vsimon.order_engine.domain.OrderId;

public interface OrderRepository {

    Order store(Order order);
    
    Order find(OrderId orderId);

}
