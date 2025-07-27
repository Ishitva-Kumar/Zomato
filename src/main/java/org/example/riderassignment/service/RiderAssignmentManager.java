package org.example.riderassignment.service;



import org.example.riderassignment.models.Order;
import org.example.riderassignment.models.OrderStatus;
import org.example.riderassignment.models.Rider;
import org.example.riderassignment.strategy.DistanceStrategy;

import java.util.List;

public class RiderAssignmentManager {
    private final List<Rider> riders;
    private final DistanceStrategy distanceStrategy;

    public RiderAssignmentManager(List<Rider> riders, DistanceStrategy distanceStrategy) {
        this.riders = riders;
        this.distanceStrategy = distanceStrategy;
    }

    public Rider assignRider(Order order) {
        Rider bestRider = null;
        double minScore = Double.MAX_VALUE; // scroring algo

        for (Rider rider : riders) {
            if (!rider.isAvailable()) continue;

            double distance = distanceStrategy.calculate(rider.getCurrentLocation(), order.getDeliveryLocation());
            double score = distance - rider.getRating();

            if (score < minScore) {
                minScore = score;
                bestRider = rider;
            }
        }

        if (bestRider != null) {
            bestRider.setAvailable(false);
            order.setStatus(OrderStatus.ASSIGNED);
            System.out.println("Assigned Rider: " + bestRider.getRiderId() + " to Order: " + order.getOrderId());
        } else { //edge case
            System.out.println("No available riders for Order: " + order.getOrderId());
        }

        return bestRider;
    }
}

