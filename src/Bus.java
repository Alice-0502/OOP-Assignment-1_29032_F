public class Bus {

    private int busId;
    private String plateNumber;
    private String busName;
    private int seatCapacity;
    private String busStatus;

    public Bus(int busId, String plateNumber, String busName, int seatCapacity, String busStatus) {
        if (busId <= 0) {
            throw new IllegalArgumentException("Bus ID must be a positive integer.");
        }
        if (plateNumber == null || plateNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Plate number must not be null or empty.");
        }
        if (busName == null || busName.trim().isEmpty()) {
            throw new IllegalArgumentException("Bus name must not be null or empty.");
        }
        if (seatCapacity <= 0) {
            throw new IllegalArgumentException("Seat capacity must be greater than zero.");
        }
        if (busStatus == null || busStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("Bus status must not be null or empty.");
        }
        String normalizedStatus = busStatus.trim().toUpperCase();
        if (!normalizedStatus.equals("AVAILABLE") && !normalizedStatus.equals("UNAVAILABLE")) {
            throw new IllegalArgumentException("Bus status must be AVAILABLE or UNAVAILABLE.");
        }
        this.busId = busId;
        this.plateNumber = plateNumber.trim();
        this.busName = busName.trim();
        this.seatCapacity = seatCapacity;
        this.busStatus = normalizedStatus;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        if (busId <= 0) {
            throw new IllegalArgumentException("Bus ID must be a positive integer.");
        }
        this.busId = busId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        if (plateNumber == null || plateNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Plate number must not be null or empty.");
        }
        this.plateNumber = plateNumber.trim();
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        if (busName == null || busName.trim().isEmpty()) {
            throw new IllegalArgumentException("Bus name must not be null or empty.");
        }
        this.busName = busName.trim();
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        if (seatCapacity <= 0) {
            throw new IllegalArgumentException("Seat capacity must be greater than zero.");
        }
        this.seatCapacity = seatCapacity;
    }

    public String getBusStatus() {
        return busStatus;
    }

    public void setBusStatus(String busStatus) {
        if (busStatus == null || busStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("Bus status must not be null or empty.");
        }
        String normalizedStatus = busStatus.trim().toUpperCase();
        if (!normalizedStatus.equals("AVAILABLE") && !normalizedStatus.equals("UNAVAILABLE")) {
            throw new IllegalArgumentException("Bus status must be AVAILABLE or UNAVAILABLE.");
        }
        this.busStatus = normalizedStatus;
    }

    @Override
    public String toString() {
        return "Bus [busId=" + busId + ", plateNumber=" + plateNumber + ", busName=" + busName
                + ", seatCapacity=" + seatCapacity + ", busStatus=" + busStatus + "]";
    }
}
