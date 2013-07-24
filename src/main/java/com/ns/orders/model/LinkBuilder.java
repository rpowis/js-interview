package com.ns.orders.model;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.Map;

public class LinkBuilder {
    private final UriBuilder uriBuilder;

    public LinkBuilder(UriInfo uriInfo, Class resourceClass, String method) {
        uriBuilder = uriInfo.getBaseUriBuilder().path(resourceClass).path(resourceClass, method);
    }

    public Link buildLink(Map<String, ? extends Object> params, String rel) {
        return new Link(uriBuilder.buildFromMap(params), rel);
    }
}
