package ru.skvrez.composite_example;

import java.math.BigDecimal;

public class OrderItem {
    private final String name;
    private final BigDecimal price;
    private final BigDecimal quantity;

    public OrderItem(String name, BigDecimal price, BigDecimal quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
