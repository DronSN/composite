package ru.skvrez.composite_example;

import java.math.BigDecimal;

public class CustomerOrder extends ItemStorage<OrderItem> implements Order {

    private final String address;
    private final String name;

    public CustomerOrder(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public CustomerOrder(CustomerOrder customerOrder) {
        super(customerOrder);
        this.address = customerOrder.address;
        this.name = customerOrder.name;
    }


    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public BigDecimal getCost() {
        return items.stream()
                .map(item -> item.getPrice().multiply(item.getQuantity()))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

    @Override
    public String getName() {
        return name;
    }

}
