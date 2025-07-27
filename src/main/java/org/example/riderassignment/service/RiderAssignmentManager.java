package org.example.riderassignment.service;



import org.example.riderassignment.models.Order;
import org.example.riderassignment.models.OrderStatus;
import org.example.riderassignment.models.Rider;
import org.example.riderassignment.strategy.DistanceStrategy;


public class RiderSystemApp {
    public static void main(String[] args) {
        List<Rider> riders = Arrays.asList(
                new Rider("R1", new Location(12.9716, 77.5946), 4.7),
                new Rider("R2", new Location(12.9611, 77.6012), 4.5),
                new Rider("R3", new Location(12.9565, 77.6000), 4.9)
        );

        DistanceStrategy strategy = new HaversineDistanceStrategy();

        RiderAssignmentCLI cli = new RiderAssignmentCLI(riders, strategy);
        cli.start();
    }
}
