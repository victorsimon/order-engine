package com.vsimon.order_engine.domain;

public record OrderLine(ProductId productId, int amount, MonetaryAmount price) 
{
}
