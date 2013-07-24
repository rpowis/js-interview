package com.ns.orders.model;

import java.net.URI;

public class Link {
    private URI link;
    private String rel;

    public Link(URI link, String rel) {
        this.link = link;
        this.rel = rel;
    }

    public URI getLink() {
        return link;
    }

    public String getRel() {
        return rel;
    }
}
