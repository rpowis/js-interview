package com.ns.orders;

import com.google.inject.Guice;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.guice.spi.container.GuiceComponentProviderFactory;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.ServerConfiguration;
import org.glassfish.grizzly.http.server.StaticHttpHandler;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args) throws IOException {
        String webAppDirectory = System.getProperty("user.dir") + "/webapp";
        String testDirectory = System.getProperty("user.dir") + "/tests";

        HttpServer httpServer = createServer();

        StaticHttpHandler appHttpHandler = new StaticHttpHandler(webAppDirectory);
        appHttpHandler.setFileCacheEnabled(false);

        StaticHttpHandler testHttpHandler = new StaticHttpHandler(testDirectory);
        testHttpHandler.setFileCacheEnabled(false);

        ServerConfiguration serverConfiguration = httpServer.getServerConfiguration();
        serverConfiguration.addHttpHandler(appHttpHandler, "/app");
        serverConfiguration.addHttpHandler(testHttpHandler, "/spec");

        httpServer.start();

        System.in.read();

        httpServer.stop();
    }

    private static HttpServer createServer() throws IOException {
        URI uri = UriBuilder.fromUri("http://localhost/").port(9998).build();

        ResourceConfig resourceConfig = new PackagesResourceConfig("com.ns.orders.resources");
        IoCComponentProviderFactory factory = new GuiceComponentProviderFactory(resourceConfig, Guice.createInjector());

        return GrizzlyServerFactory.createHttpServer(uri, resourceConfig, factory);
    }
}