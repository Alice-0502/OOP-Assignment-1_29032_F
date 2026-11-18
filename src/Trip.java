public class Trip {

    private int tripId;
    private Bus bus;
    private Driver driver;
    private Route route;
    private String departureTime;

    public Trip(int tripId, Bus bus, Driver driver, Route route, String departureTime) {
        if (tripId <= 0) {
            throw new IllegalArgumentException("Trip ID must be a positive integer.");
        }
        if (bus == null) {
            throw new IllegalArgumentException("Trip must reference a registered bus.");
        }
        if (driver == null) {
            throw new IllegalArgumentException("Trip must reference a registered driver.");
        }
        if (route == null) {
            throw new IllegalArgumentException("Trip must reference a registered route.");
        }
        if (departureTime == null || departureTime.trim().isEmpty()) {
            throw new IllegalArgumentException("Departure time must not be null or empty.");
        }
        this.tripId = tripId;
        this.bus = bus;
        this.driver = driver;
        this.route = route;
        this.departureTime = departureTime.trim();
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        if (tripId <= 0) {
            throw new IllegalArgumentException("Trip ID must be a positive integer.");
        }
        this.tripId = tripId;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        if (bus == null) {
            throw new IllegalArgumentException("Trip must reference a registered bus.");
        }
        this.bus = bus;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Trip must reference a registered driver.");
        }
        this.driver = driver;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        if (route == null) {
            throw new IllegalArgumentException("Trip must reference a registered route.");
        }
        this.route = route;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        if (departureTime == null || departureTime.trim().isEmpty()) {
            throw new IllegalArgumentException("Departure time must not be null or empty.");
        }
        this.departureTime = departureTime.trim();
    }

    @Override
    public String toString() {
        return "Trip [tripId=" + tripId
                + ", bus=" + bus.getPlateNumber() + " (" + bus.getBusName() + ")"
                + ", driver=" + driver.getDriverName() + " (" + driver.getLicenseNumber() + ")"
                + ", route=" + route.getDepartureLocation() + " -> " + route.getDestinationLocation()
                + ", departureTime=" + departureTime + "]";
    }
}
