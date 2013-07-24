package com.ns.orders.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        orders = buildOrders();
    }

    public List<Order> getOrders() {
        return orders;
    }

    private List<Order> buildOrders() {
        List<Order> orders = new ArrayList<Order>();
        orders.add(buildOrder(1, 5));
        orders.add(buildOrder(2, 3));

        return orders;
    }

    private Order buildOrder(int orderNumber, int numberOfLines) {
        Random random = new Random();

        List<OrderLine> orderLines = new ArrayList<OrderLine>();

        for (int i = 0; i < numberOfLines; i++) {
            orderLines.add(new OrderLine(i, random.nextInt(1000)));
        }

        return new Order(orderNumber, new Date(), orderLines);
    }
}
