package mfe.ch07;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoutes extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("direct:firstRoute")
                .log("Camel body: ${body}");
    }

}