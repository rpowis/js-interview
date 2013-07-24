package com.ns.orders.resources;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.ns.orders.model.Order;
import com.ns.orders.model.OrderRepository;
import com.sun.jersey.api.NotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/order")
public class OrderResource {
    private OrderRepository orderRepository;

    @Inject
    public OrderResource(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GET
    @Path("/{orderNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrder(@PathParam("orderNumber") int orderNumber) {
        Order requestedOrder = null;

        for (Order order : orderRepository.getOrders()) {
            if (order.getOrderNumber() == orderNumber) {
                requestedOrder = order;
            }
        }

        if (requestedOrder == null) {
            throw new NotFoundException();
        }

        return new Gson().toJson(requestedOrder);
    }
}
