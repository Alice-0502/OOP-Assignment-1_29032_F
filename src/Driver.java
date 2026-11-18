public class Driver {

    private int driverId;
    private String driverName;
    private String driverPhone;
    private String licenseNumber;
    private int driverAge;

    public Driver(int driverId, String driverName, String driverPhone, String licenseNumber, int driverAge) {
        if (driverId <= 0) {
            throw new IllegalArgumentException("Driver ID must be a positive integer.");
        }
        if (driverName == null || driverName.trim().isEmpty()) {
            throw new IllegalArgumentException("Driver name must not be null or empty.");
        }
        if (containsDigit(driverName)) {
            throw new IllegalArgumentException("Driver name must not contain numeric characters.");
        }
        if (driverPhone == null || driverPhone.trim().isEmpty()) {
            throw new IllegalArgumentException("Driver phone must not be null or empty.");
        }
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("License number must not be null or empty.");
        }
        if (driverAge < 21 || driverAge > 65) {
            throw new IllegalArgumentException("Driver age must be between 21 and 65 years.");
        }
        this.driverId = driverId;
        this.driverName = driverName.trim();
        this.driverPhone = driverPhone.trim();
        this.licenseNumber = licenseNumber.trim();
        this.driverAge = driverAge;
    }

    private static boolean containsDigit(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        if (driverId <= 0) {
            throw new IllegalArgumentException("Driver ID must be a positive integer.");
        }
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        if (driverName == null || driverName.trim().isEmpty()) {
            throw new IllegalArgumentException("Driver name must not be null or empty.");
        }
        if (containsDigit(driverName)) {
            throw new IllegalArgumentException("Driver name must not contain numeric characters.");
        }
        this.driverName = driverName.trim();
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        if (driverPhone == null || driverPhone.trim().isEmpty()) {
            throw new IllegalArgumentException("Driver phone must not be null or empty.");
        }
        this.driverPhone = driverPhone.trim();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("License number must not be null or empty.");
        }
        this.licenseNumber = licenseNumber.trim();
    }

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(int driverAge) {
        if (driverAge < 21 || driverAge > 65) {
            throw new IllegalArgumentException("Driver age must be between 21 and 65 years.");
        }
        this.driverAge = driverAge;
    }

    @Override
    public String toString() {
        return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", driverPhone=" + driverPhone
                + ", licenseNumber=" + licenseNumber + ", driverAge=" + driverAge + "]";
    }
}
