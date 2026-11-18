public class Route {

    private int routeId;
    private String departureLocation;
    private String destinationLocation;
    private double distance;
    private double ticketPrice;

    public Route(int routeId, String departureLocation, String destinationLocation, double distance,
                 double ticketPrice) {
        if (routeId <= 0) {
            throw new IllegalArgumentException("Route ID must be a positive integer.");
        }
        if (departureLocation == null || departureLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Departure location must not be null or empty.");
        }
        if (destinationLocation == null || destinationLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination location must not be null or empty.");
        }
        if (departureLocation.trim().equalsIgnoreCase(destinationLocation.trim())) {
            throw new IllegalArgumentException("Departure and destination locations must not be identical.");
        }
        if (distance <= 0) {
            throw new IllegalArgumentException("Route distance must be greater than zero.");
        }
        if (ticketPrice <= 0) {
            throw new IllegalArgumentException("Ticket price must be greater than zero.");
        }
        this.routeId = routeId;
        this.departureLocation = departureLocation.trim();
        this.destinationLocation = destinationLocation.trim();
        this.distance = distance;
        this.ticketPrice = ticketPrice;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        if (routeId <= 0) {
            throw new IllegalArgumentException("Route ID must be a positive integer.");
        }
        this.routeId = routeId;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        if (departureLocation == null || departureLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Departure location must not be null or empty.");
        }
        this.departureLocation = departureLocation.trim();
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        if (destinationLocation == null || destinationLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination location must not be null or empty.");
        }
        this.destinationLocation = destinationLocation.trim();
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Route distance must be greater than zero.");
        }
        this.distance = distance;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        if (ticketPrice <= 0) {
            throw new IllegalArgumentException("Ticket price must be greater than zero.");
        }
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Route [routeId=" + routeId + ", departureLocation=" + departureLocation
                + ", destinationLocation=" + destinationLocation + ", distance=" + distance
                + ", ticketPrice=" + ticketPrice + "]";
    }
}
