package com.vsimon.order_engine.domain.port.in;

import com.vsimon.order_engine.domain.OrderId;

public interface CustomerPaidsOrder {

    OrderId execute(OrderId orderId);

}
