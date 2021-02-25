package ru.skvrez.composite_example;

import java.math.BigDecimal;

public interface Order {
    String getAddress();
    BigDecimal getCost();
    String getName();
}
