package com.vsimon.order_engine.domain.port.in;

import org.springframework.lang.NonNull;

import com.vsimon.order_engine.domain.OrderId;

public interface CustomerCancelsOrder {

    OrderId execute(@NonNull OrderId orderId);
    
}
