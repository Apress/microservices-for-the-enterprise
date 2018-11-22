package hello;

public class Order {

    private String orderId;
    private String description;

    public Order() {
    }

    public Order(String orderId, String description) {
        this.orderId = orderId;
        this.description = description;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Order{orderId=%s, description=%s}", getOrderId(), getDescription());
    }

}
