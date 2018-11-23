package hello;

public class OrderStatus {
    private String statusMsg;
    private String orderId;

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderStatus(String statusMsg, String orderId) {
        this.statusMsg = statusMsg;
        this.orderId = orderId;
    }
}
