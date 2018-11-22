package hello;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "pending_orders", containerFactory = "myFactory")
    public void receiveMessage(Order order) {
        System.out.println("Received <" + order + ">");
    }

}
