package com.vsimon.order_engine.domain;

public record OrderState(OrderId orderId, State state) {

    public enum State {
        CREATED, CANCELED, PAID, SHIPPED, RETURNED
    }

    public static OrderState of(Order order, State state) {
        return new OrderState(order.orderId(), state);
    }

    public OrderState promoteTo(State state) {
        return new OrderState(this.orderId, state);
    }
}
