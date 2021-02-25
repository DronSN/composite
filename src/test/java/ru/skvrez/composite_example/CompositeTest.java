package ru.skvrez.composite_example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CompositeTest {

    private final BigDecimal ITEM1_PRICE = BigDecimal.valueOf(10);
    private final BigDecimal ITEM1_COUNT = BigDecimal.valueOf(5);
    private final BigDecimal ITEM2_PRICE = BigDecimal.valueOf(2.5);
    private final BigDecimal ITEM2_COUNT = BigDecimal.valueOf(2);
    private final BigDecimal ITEM3_PRICE = BigDecimal.valueOf(20);
    private final BigDecimal ITEM3_COUNT = BigDecimal.valueOf(1);
    private final BigDecimal ORDER_AMOUNT = BigDecimal.valueOf(75.0);
    private final int REMOVE_ITEM_INDEX = 0;
    private final BigDecimal ORDER_AMOUNT_AFTER_REMOVE = BigDecimal.valueOf(75.0);
    private final BigDecimal PACKAGE_IN_PACKAGE_AMOUNT = BigDecimal.valueOf(150.0);


    CustomerOrder order;
    Package aPackage;
    List<OrderItem> orderItems;
    Package packageInPackage;

    @BeforeEach
    public void fillTestData() {
        OrderItem orderItem1 = new OrderItem("Молоток", ITEM1_PRICE, ITEM1_COUNT);
        OrderItem orderItem2 = new OrderItem("Чашки", ITEM2_PRICE, ITEM2_COUNT);
        OrderItem orderItem3 = new OrderItem("Красивая чашка", ITEM3_PRICE, ITEM3_COUNT);
        orderItems = new ArrayList<>(List.of(orderItem1, orderItem2, orderItem3));
        order = new CustomerOrder("Москва, Ленина 45", "Молотки да Чашки");
        order.add(orderItems);

        aPackage = new Package("Москва Ленина", "Для Иванова");
        aPackage.add(order);

        packageInPackage = new Package("Москва", "Для Москвы");
        packageInPackage.add(aPackage);
        packageInPackage.add(new CustomerOrder(order));
    }

    @Test
    void testOrderAmount() {
        Assertions.assertEquals(order.getCost(), ORDER_AMOUNT);
    }

    @Test
    void testOrderAmountAfterRemove() {
        orderItems.remove(REMOVE_ITEM_INDEX);
        Assertions.assertEquals(order.getCost(), ORDER_AMOUNT_AFTER_REMOVE);
    }

    @Test
    void testPackageAmount() {
        Assertions.assertEquals(aPackage.getCost(), ORDER_AMOUNT);
    }

    @Test
    void testPackageInPackageAmount() {
        Assertions.assertEquals(packageInPackage.getCost(), PACKAGE_IN_PACKAGE_AMOUNT);
    }
}
