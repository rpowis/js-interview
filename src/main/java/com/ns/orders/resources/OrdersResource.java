package com.ns.orders.resources;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.ns.orders.model.*;
import com.sun.jersey.api.NotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.*;

@Path("/orders")
public class OrdersResource {
    private OrderRepository orderRepository;

    @Inject
    public OrdersResource(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrders(@Context UriInfo uriInfo) {
        List<Order> orders = orderRepository.getOrders();

        return new Gson().toJson(getOrderSummaries(orders, uriInfo));
    }

    private List<OrderSummary> getOrderSummaries(List<Order> orders, UriInfo uriInfo) {
        List<OrderSummary> orderSummaries = new ArrayList<OrderSummary>();

        LinkBuilder linkBuilder = new LinkBuilder(uriInfo, OrderResource.class, "getOrder");
        Map<String, Integer> uriParams = new HashMap<String, Integer>();

        for (Order order : orders) {
            uriParams.put("orderNumber", order.getOrderNumber());

            orderSummaries.add(new OrderSummary(order, linkBuilder.buildLink(uriParams, "urn:order:detail")));
        }

        return orderSummaries;
    }
}
