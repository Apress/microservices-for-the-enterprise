package mfe.ch07;

import io.vertx.core.Vertx;


public class HelloWorldService {
    public static void main(String[] args) {
        Vertx.vertx().createHttpServer()
                .requestHandler(req -> req.response().end("Hello \"Microservices for Enterprise\"!!! - Vert.x\n"))
                .listen(8080);
    }
}
