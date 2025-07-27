package org.example.riderassignment.models;



public class Order {
    private final String orderId;
    private final Location deliveryLocation;
    private OrderStatus status;

    public Order(String orderId, Location deliveryLocation) {
        this.orderId = orderId;
        this.deliveryLocation = deliveryLocation;
        this.status = OrderStatus.PENDING;
    }

    public String getOrderId() {
        return orderId;
    }

    public Location getDeliveryLocation() {
        return deliveryLocation;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

