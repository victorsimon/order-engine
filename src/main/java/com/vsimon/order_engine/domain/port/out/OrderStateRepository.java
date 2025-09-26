package com.vsimon.order_engine.domain.port.out;

import com.vsimon.order_engine.domain.OrderId;
import com.vsimon.order_engine.domain.OrderState;

public interface OrderStateRepository {

    OrderState store(OrderState orderState);

    OrderState find(OrderId orderId);

}
