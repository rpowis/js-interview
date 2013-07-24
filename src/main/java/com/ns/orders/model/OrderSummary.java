package com.ns.orders.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OrderSummary {
    private final int orderNumber;
    private final Date orderDate;
    private final List<Link> links;

    public OrderSummary(Order order, Link detailLink) {
        this.orderNumber = order.getOrderNumber();
        this.orderDate = order.getOrderDate();
        this.links = Arrays.asList(detailLink);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<Link> getLinks() {
        return links;
    }
}
