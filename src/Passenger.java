public class Passenger {

    private int passengerId;
    private String passengerName;
    private String passengerEmail;
    private int passengerAge;
    private String passengerPhone;

    public Passenger(int passengerId, String passengerName, String passengerEmail, int passengerAge,
                     String passengerPhone) {
        if (passengerId <= 0) {
            throw new IllegalArgumentException("Passenger ID must be a positive integer.");
        }
        if (passengerName == null || passengerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Passenger name must not be null or empty.");
        }
        if (containsDigit(passengerName)) {
            throw new IllegalArgumentException("Passenger name must not contain numeric characters.");
        }
        if (passengerEmail == null || passengerEmail.trim().isEmpty()) {
            throw new IllegalArgumentException("Passenger email must not be null or empty.");
        }
        if (!isValidEmail(passengerEmail.trim())) {
            throw new IllegalArgumentException("Passenger email must have a valid basic format (e.g. name@mail.com).");
        }
        if (passengerAge < 0 || passengerAge > 120) {
            throw new IllegalArgumentException("Passenger age must be between 0 and 120 years.");
        }
        if (passengerPhone == null || passengerPhone.trim().isEmpty()) {
            throw new IllegalArgumentException("Passenger phone must not be null or empty.");
        }
        if (!isValidPhone(passengerPhone.trim())) {
            throw new IllegalArgumentException("Passenger phone must contain exactly 10 digits.");
        }
        this.passengerId = passengerId;
        this.passengerName = passengerName.trim();
        this.passengerEmail = passengerEmail.trim();
        this.passengerAge = passengerAge;
        this.passengerPhone = passengerPhone.trim();
    }

    private static boolean containsDigit(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidEmail(String email) {
        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex != email.lastIndexOf('@')) {
            return false;
        }
        String local = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);
        return !local.isEmpty() && !domain.isEmpty() && domain.contains(".")
                && domain.indexOf('.') > 0 && domain.indexOf('.') < domain.length() - 1;
    }

    private static boolean isValidPhone(String phone) {
        if (phone.length() != 10) {
            return false;
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        if (passengerId <= 0) {
            throw new IllegalArgumentException("Passenger ID must be a positive integer.");
        }
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        if (passengerName == null || passengerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Passenger name must not be null or empty.");
        }
        if (containsDigit(passengerName)) {
            throw new IllegalArgumentException("Passenger name must not contain numeric characters.");
        }
        this.passengerName = passengerName.trim();
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        if (passengerEmail == null || passengerEmail.trim().isEmpty()) {
            throw new IllegalArgumentException("Passenger email must not be null or empty.");
        }
        if (!isValidEmail(passengerEmail.trim())) {
            throw new IllegalArgumentException("Passenger email must have a valid basic format (e.g. name@mail.com).");
        }
        this.passengerEmail = passengerEmail.trim();
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        if (passengerAge < 0 || passengerAge > 120) {
            throw new IllegalArgumentException("Passenger age must be between 0 and 120 years.");
        }
        this.passengerAge = passengerAge;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        if (passengerPhone == null || passengerPhone.trim().isEmpty()) {
            throw new IllegalArgumentException("Passenger phone must not be null or empty.");
        }
        if (!isValidPhone(passengerPhone.trim())) {
            throw new IllegalArgumentException("Passenger phone must contain exactly 10 digits.");
        }
        this.passengerPhone = passengerPhone.trim();
    }

    @Override
    public String toString() {
        return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName
                + ", passengerEmail=" + passengerEmail + ", passengerAge=" + passengerAge
                + ", passengerPhone=" + passengerPhone + "]";
    }
}
