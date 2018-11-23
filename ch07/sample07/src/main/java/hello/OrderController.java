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

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerId(1234);
        customerInfo.setFirstName("John");
        customerInfo.setLastName("Doe");
        customerInfo.setAddress("52, River Oaks, San Jose, CA 95133");
        sampleOrder.setCustomerInfo(customerInfo);

        orderMap.put(sampleOrder.getId(), sampleOrder);
    }

    @GetMapping(path = "/order/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Order getOrder(@PathVariable String id) {
        Order order = (Order) orderMap.get(id);
        return order;
    }


    @PostMapping(path = "/order",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
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
