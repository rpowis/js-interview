package com.ns.orders.model;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderNumber;
    private Date orderDate;

    private List<OrderLine> orderLines;

    public Order(int orderNumber, Date orderDate, List<OrderLine> orderLines) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderLines = orderLines;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
}
