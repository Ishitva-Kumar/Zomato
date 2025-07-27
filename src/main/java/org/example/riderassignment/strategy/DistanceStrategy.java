package org.example.riderassignment.strategy;


import org.example.riderassignment.models.Location;

public interface DistanceStrategy {
    double calculate(Location a, Location b);
}
