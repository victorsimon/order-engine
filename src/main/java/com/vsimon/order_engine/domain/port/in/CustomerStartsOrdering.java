package com.vsimon.order_engine.domain.port.in;

import org.springframework.lang.Nullable;

import com.vsimon.order_engine.domain.Order;
import com.vsimon.order_engine.domain.OrderId;

public interface CustomerStartsOrdering {
    
    OrderId execute(@Nullable Order order);
    
}
