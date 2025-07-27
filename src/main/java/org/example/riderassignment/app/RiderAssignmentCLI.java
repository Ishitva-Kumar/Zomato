package org.example.riderassignment.controller;

import org.example.riderassignment.models.*;
import org.example.riderassignment.service.RiderAssignmentManager;
import org.example.riderassignment.strategy.DistanceStrategy;

import java.util.List;
import java.util.Scanner;

public class RiderAssignmentCLI {

    private final RiderAssignmentManager manager;

    public RiderAssignmentCLI(List<Rider> riders, DistanceStrategy strategy) {
        this.manager = new RiderAssignmentManager(riders, strategy);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order ID, Latitude, Longitude (or type 'exit'):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            String[] parts = input.split(",");
            if (parts.length != 3) {
                System.out.println("Invalid input format. Try: O1,12.9610,77.6001");
                continue;
            }

            String orderId = parts[0].trim();
            double lat = Double.parseDouble(parts[1].trim());
            double lon = Double.parseDouble(parts[2].trim());

            Order order = new Order(orderId, new Location(lat, lon));
            manager.assignRider(order);
        }

        System.out.println("Exiting Rider Assignment CLI...");
    }
}
