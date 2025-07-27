package org.example.riderassignment.models;


public class Rider {
    private final String riderId;
    private Location currentLocation;
    private boolean isAvailable;
    private double rating;

    public Rider(String riderId, Location currentLocation, double rating) {
        this.riderId = riderId;
        this.currentLocation = currentLocation;
        this.rating = rating;
        this.isAvailable = true;
    }

    public String getRiderId() {
        return riderId;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getRating() {
        return rating;
    }
}

