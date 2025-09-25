package com.vsimon.order_engine.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.jupiter.api.Test;

public class MonetaryAmountTest {

    final Currency EURO = Currency.getInstance("EUR");
    final Currency DOLLAR = Currency.getInstance("USD");

    @Test
    void testEquals() {
        // Given
        MonetaryAmount m1 = MonetaryAmount.of(new BigDecimal(1), EURO);
        MonetaryAmount m2 = MonetaryAmount.of(new BigDecimal(1), EURO);

        // When 
        // Then
        assertEquals(m1, m2);
    }

    @Test
    void testNotEquals() {
        // Given
        MonetaryAmount m1 = MonetaryAmount.of(new BigDecimal(1), EURO);
        MonetaryAmount m2 = MonetaryAmount.of(new BigDecimal(2), EURO);
        MonetaryAmount m3 = MonetaryAmount.of(new BigDecimal(2), DOLLAR);

        // When 
        // Then
        assertNotEquals(m1, m2);
        assertNotEquals(m1, m3);
        assertNotEquals(m2, m3);
    }

    @Test
    void testOf() {
        // Given
        MonetaryAmount sut;        
        
        // When
        sut = MonetaryAmount.of(new BigDecimal(0), EURO);
        
        // Then
        assertNotNull(sut);
    }

    @Test
    void testOfMustFailIfAnyNull() {
        // Given
        
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            MonetaryAmount.of(null, null);
        });        

    }

    @Test
    void testOfMustFailIfNegativeAmount() {
        // Given
        
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            MonetaryAmount.of(new BigDecimal(-1), EURO);
        });        

    }

    @Test
    void testOfMustFailIfMoreThan6DigitsAmount() {
        // Given
        
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            MonetaryAmount.of(new BigDecimal(1111111), EURO);
        });        

    }

    @Test
    void testOfMustFailIfMoreThan2DecimalsAmount() {
        // Given
        
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            MonetaryAmount.of(new BigDecimal(1111.111), EURO);
        });        

    }
}
