package hello;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private HashMap orderMap = new HashMap<String, Order>();

    public OrderController() {
        Order sampleOrder = new Order();
        sampleOrder.setId("100");
        sampleOrder.setName("iPhone10");
        sampleOrder.setDescription("iPhone10 from Apple.");
        orderMap.put(sampleOrder.getId(), sampleOrder);
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable String id) {
        Order order = (Order) orderMap.get(id);
        return order;
    }


    @PostMapping(value = "/order", consumes = "application/json")
    public OrderStatus addOrder(@RequestBody Order order) {

        OrderStatus status = new OrderStatus("", "-1");
        if (order != null) {
            orderMap.put(order.getId(), order);
            status.setOrderId(order.getId());
            status.setStatusMsg("Successful");
        }
        return status;
    }
}
