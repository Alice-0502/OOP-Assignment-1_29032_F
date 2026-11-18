public class Booking {

    private int bookingId;
    private Passenger passenger;
    private Trip trip;
    private int seatNumber;
    private String bookingStatus;

    public Booking(int bookingId, Passenger passenger, Trip trip, int seatNumber, String bookingStatus) {
        if (bookingId <= 0) {
            throw new IllegalArgumentException("Booking ID must be a positive integer.");
        }
        if (passenger == null) {
            throw new IllegalArgumentException("Booking must reference a registered passenger.");
        }
        if (trip == null) {
            throw new IllegalArgumentException("Booking must reference a scheduled trip.");
        }
        int seatCapacity = trip.getBus().getSeatCapacity();
        if (seatNumber < 1 || seatNumber > seatCapacity) {
            throw new IllegalArgumentException(
                    "Seat number must be between 1 and the bus seating capacity (" + seatCapacity + ").");
        }
        if (bookingStatus == null || bookingStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("Booking status must not be null or empty.");
        }
        String normalizedStatus = bookingStatus.trim().toUpperCase();
        if (!normalizedStatus.equals("ACTIVE") && !normalizedStatus.equals("CANCELLED")) {
            throw new IllegalArgumentException("Booking status must be ACTIVE or CANCELLED.");
        }
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.trip = trip;
        this.seatNumber = seatNumber;
        this.bookingStatus = normalizedStatus;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        if (bookingId <= 0) {
            throw new IllegalArgumentException("Booking ID must be a positive integer.");
        }
        this.bookingId = bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Booking must reference a registered passenger.");
        }
        this.passenger = passenger;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        if (trip == null) {
            throw new IllegalArgumentException("Booking must reference a scheduled trip.");
        }
        int seatCapacity = trip.getBus().getSeatCapacity();
        if (this.seatNumber < 1 || this.seatNumber > seatCapacity) {
            throw new IllegalArgumentException(
                    "Seat number must be between 1 and the bus seating capacity (" + seatCapacity + ").");
        }
        this.trip = trip;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        int seatCapacity = trip.getBus().getSeatCapacity();
        if (seatNumber < 1 || seatNumber > seatCapacity) {
            throw new IllegalArgumentException(
                    "Seat number must be between 1 and the bus seating capacity (" + seatCapacity + ").");
        }
        this.seatNumber = seatNumber;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        if (bookingStatus == null || bookingStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("Booking status must not be null or empty.");
        }
        String normalizedStatus = bookingStatus.trim().toUpperCase();
        if (!normalizedStatus.equals("ACTIVE") && !normalizedStatus.equals("CANCELLED")) {
            throw new IllegalArgumentException("Booking status must be ACTIVE or CANCELLED.");
        }
        this.bookingStatus = normalizedStatus;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId
                + ", passengerId=" + passenger.getPassengerId() + " (" + passenger.getPassengerName() + ")"
                + ", tripId=" + trip.getTripId()
                + ", seatNumber=" + seatNumber
                + ", bookingStatus=" + bookingStatus + "]";
    }
}
