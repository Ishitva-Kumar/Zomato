package org.example.riderassignment.app;
import org.example.riderassignment.models.* ;
import org.example.riderassignment.models.Location;
import org.example.riderassignment.service.RiderAssignmentManager;
import org.example.riderassignment.strategy.*;

import java.util.Arrays;
import java.util.List;

// ----------------------------
// Main Runner for Testing
// ----------------------------


public class RiderSystemApp {
    public static void main(String[] args) {
        List<Rider> riders = Arrays.asList(
                new Rider("R1", new Location(12.9716, 77.5946), 4.7),
                new Rider("R2", new Location(12.9611, 77.6012), 4.5),
                new Rider("R3", new Location(12.9565, 77.6000), 4.9)
        );

        Order order = new Order("O1", new Location(12.9600, 77.6000));

        DistanceStrategy strategy = new HaversineDistanceStrategy();
        RiderAssignmentManager manager = new RiderAssignmentManager(riders, strategy);

        manager.assignRider(order);
    }
}

