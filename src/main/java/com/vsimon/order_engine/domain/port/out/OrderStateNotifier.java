package com.vsimon.order_engine.domain.port.out;

import com.vsimon.order_engine.domain.OrderId;
import com.vsimon.order_engine.domain.OrderState;

public interface OrderStateNotifier {

    void orderStateUpdated(OrderId orderId, OrderState.State state);

}
