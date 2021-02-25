package ru.skvrez.composite_example;

import java.math.BigDecimal;

public class Package extends ItemStorage<Order> implements Order{

    private final String address;
    private final String name;

    public Package(String address, String name) {
        this.address = address;
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public BigDecimal getCost() {
        return items.stream()
                .map(Order::getCost)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

    @Override
    public String getName() {
        return name;
    }
}
