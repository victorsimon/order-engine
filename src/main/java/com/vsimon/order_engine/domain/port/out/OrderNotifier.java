package com.vsimon.order_engine.domain.port.out;

import com.vsimon.order_engine.domain.OrderId;
import com.vsimon.order_engine.domain.OrderLine;

public interface OrderNotifier {

    void orderCreated(OrderId orderId);

    void lineAddedToOrder(OrderId orderId, OrderLine orderLine);

}
