package com.vsimon.order_engine.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderTest {

    @Test
    void shouldCreateAnOrderWithValidData() {
        // Given
        CustomerId customerId = new CustomerId("123");
        MonetaryAmount price = MonetaryAmount.of(new BigDecimal(25), Currency.getInstance("EUR"));
        Set<OrderLine> orderLines = Set.of(
            new OrderLine(new ProductId("prod-1"), 2, price)
        );

        // When
        Order order = Order.create(customerId, orderLines);

        // Then
        assertNotNull(order);
        assertEquals(customerId, order.customerId());
        assertEquals(1, order.orderLines().size());
        assertEquals(price, order.orderLines().iterator().next().price());
    }
}
