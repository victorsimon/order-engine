package com.vsimon.order_engine.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.stream.Collectors;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Value;

@Getter
@Value
public class MonetaryAmount {

    static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @NotNull(message = "Amount must not be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Amount must be positive")
    @Digits(integer=6, fraction=2, message = "Amount value must have max 6 digits and 2 decimals")
    final BigDecimal amount;
    @NotNull(message = "Currency must not be null")
    final Currency currency;

    private MonetaryAmount(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
        String violations = validator.validate(this)
                                .stream()
                                .map(violation -> violation.getMessage())
                                .collect(Collectors.joining("\n"));
        if (null != violations && !violations.isBlank()) 
            throw new IllegalArgumentException(violations);            
    }

    public static MonetaryAmount of(final BigDecimal amount, final Currency currency) {
        return new MonetaryAmount(amount, currency);
    }
}
