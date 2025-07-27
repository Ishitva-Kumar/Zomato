package org.example.riderassignment.strategy;


import org.example.riderassignment.models.Location;

public class HaversineDistanceStrategy implements DistanceStrategy {

    @Override
    public double calculate(Location a, Location b) {
        final int R = 6371; // Radius of Earth in kilometers
        double latDistance = Math.toRadians(b.getLatitude() - a.getLatitude());
        double lonDistance = Math.toRadians(b.getLongitude() - a.getLongitude());

        double sinLat = Math.sin(latDistance / 2);
        double sinLon = Math.sin(lonDistance / 2);

        double aCalc = sinLat * sinLat +
                Math.cos(Math.toRadians(a.getLatitude())) * Math.cos(Math.toRadians(b.getLatitude())) *
                        sinLon * sinLon;
        double c = 2 * Math.atan2(Math.sqrt(aCalc), Math.sqrt(1 - aCalc));

        return R * c; // Distance in km
    }
}
