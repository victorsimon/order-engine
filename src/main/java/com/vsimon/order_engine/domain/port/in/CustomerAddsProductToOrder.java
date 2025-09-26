package com.vsimon.order_engine.domain.port.in;

import com.vsimon.order_engine.domain.MonetaryAmount;
import com.vsimon.order_engine.domain.OrderId;
import com.vsimon.order_engine.domain.ProductId;

public interface CustomerAddsProductToOrder {

    OrderId execute(OrderId orderId, ProductId productId, Integer amount, MonetaryAmount price);
    
}
