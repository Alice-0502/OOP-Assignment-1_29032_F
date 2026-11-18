public class Payment {

    private int paymentId;
    private Booking booking;
    private double amountPaid;
    private String paymentMethod;
    private String paymentStatus;

    public Payment(int paymentId, Booking booking, double amountPaid, String paymentMethod,
                   String paymentStatus) {
        if (paymentId <= 0) {
            throw new IllegalArgumentException("Payment ID must be a positive integer.");
        }
        if (booking == null) {
            throw new IllegalArgumentException("Payment must reference an existing booking.");
        }
        if (amountPaid <= 0) {
            throw new IllegalArgumentException("Amount paid must be greater than zero.");
        }
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment method must not be null or empty.");
        }
        String normalizedMethod = paymentMethod.trim().toUpperCase();
        if (!normalizedMethod.equals("CASH") && !normalizedMethod.equals("MOBILE MONEY")
                && !normalizedMethod.equals("CARD")) {
            throw new IllegalArgumentException("Payment method must be CASH, MOBILE MONEY or CARD.");
        }
        if (paymentStatus == null || paymentStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment status must not be null or empty.");
        }
        String normalizedStatus = paymentStatus.trim().toUpperCase();
        if (!normalizedStatus.equals("PAID") && !normalizedStatus.equals("FAILED")) {
            throw new IllegalArgumentException("Payment status must be PAID or FAILED.");
        }
        this.paymentId = paymentId;
        this.booking = booking;
        this.amountPaid = amountPaid;
        this.paymentMethod = normalizedMethod;
        this.paymentStatus = normalizedStatus;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        if (paymentId <= 0) {
            throw new IllegalArgumentException("Payment ID must be a positive integer.");
        }
        this.paymentId = paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Payment must reference an existing booking.");
        }
        this.booking = booking;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        if (amountPaid <= 0) {
            throw new IllegalArgumentException("Amount paid must be greater than zero.");
        }
        this.amountPaid = amountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment method must not be null or empty.");
        }
        String normalizedMethod = paymentMethod.trim().toUpperCase();
        if (!normalizedMethod.equals("CASH") && !normalizedMethod.equals("MOBILE MONEY")
                && !normalizedMethod.equals("CARD")) {
            throw new IllegalArgumentException("Payment method must be CASH, MOBILE MONEY or CARD.");
        }
        this.paymentMethod = normalizedMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        if (paymentStatus == null || paymentStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment status must not be null or empty.");
        }
        String normalizedStatus = paymentStatus.trim().toUpperCase();
        if (!normalizedStatus.equals("PAID") && !normalizedStatus.equals("FAILED")) {
            throw new IllegalArgumentException("Payment status must be PAID or FAILED.");
        }
        this.paymentStatus = normalizedStatus;
    }

    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId
                + ", bookingId=" + booking.getBookingId()
                + ", passenger=" + booking.getPassenger().getPassengerName()
                + ", tripId=" + booking.getTrip().getTripId()
                + ", amountPaid=" + amountPaid
                + ", paymentMethod=" + paymentMethod
                + ", paymentStatus=" + paymentStatus + "]";
    }
}
