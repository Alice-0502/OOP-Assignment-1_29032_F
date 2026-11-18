import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static final ArrayList<Bus> buses = new ArrayList<>();
    private static final ArrayList<Driver> drivers = new ArrayList<>();
    private static final ArrayList<Route> routes = new ArrayList<>();
    private static final ArrayList<Passenger> passengers = new ArrayList<>();
    private static final ArrayList<Trip> trips = new ArrayList<>();
    private static final ArrayList<Booking> bookings = new ArrayList<>();
    private static final ArrayList<Payment> payments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("BUS TRANSPORT MANAGEMENT SYSTEM");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt(scanner, "Enter your choice: ");
            switch (choice) {
                case 1:
                    registerBus(scanner);
                    break;
                case 2:
                    registerDriver(scanner);
                    break;
                case 3:
                    registerRoute(scanner);
                    break;
                case 4:
                    registerPassenger(scanner);
                    break;
                case 5:
                    scheduleTrip(scanner);
                    break;
                case 6:
                    bookTicket(scanner);
                    break;
                case 7:
                    cancelBooking(scanner);
                    break;
                case 8:
                    processPayment(scanner);
                    break;
                case 9:
                    viewAllBuses();
                    break;
                case 10:
                    viewAllDrivers();
                    break;
                case 11:
                    viewAllRoutes();
                    break;
                case 12:
                    viewAllPassengers();
                    break;
                case 13:
                    viewAllTrips();
                    break;
                case 14:
                    viewAllBookings();
                    break;
                case 15:
                    viewAllPayments();
                    break;
                case 16:
                    searchBusByPlateNumber(scanner);
                    break;
                case 17:
                    searchDriverByLicenseNumber(scanner);
                    break;
                case 18:
                    searchPassengerByPhoneNumber(scanner);
                    break;
                case 19:
                    searchTripByTripId(scanner);
                    break;
                case 20:
                    searchBookingByBookingId(scanner);
                    break;
                case 21:
                    checkAvailableSeats(scanner);
                    break;
                case 22:
                    running = false;
                    System.out.println("Thank you for using the Bus Transport Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid menu selection. Please enter a number between 1 and 22.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("============================================");
        System.out.println("BUS TRANSPORT MANAGEMENT SYSTEM");
        System.out.println("1. Register Bus");
        System.out.println("2. Register Driver");
        System.out.println("3. Register Route");
        System.out.println("4. Register Passenger");
        System.out.println("5. Schedule Trip");
        System.out.println("6. Book Ticket");
        System.out.println("7. Cancel Booking");
        System.out.println("8. Process Payment");
        System.out.println("9. View All Buses");
        System.out.println("10. View All Drivers");
        System.out.println("11. View All Routes");
        System.out.println("12. View All Passengers");
        System.out.println("13. View All Scheduled Trips");
        System.out.println("14. View All Bookings");
        System.out.println("15. View All Payments");
        System.out.println("16. Search Bus by Plate Number");
        System.out.println("17. Search Driver by License Number");
        System.out.println("18. Search Passenger by Phone Number");
        System.out.println("19. Search Trip by Trip ID");
        System.out.println("20. Search Booking by Booking ID");
        System.out.println("21. Check Available Seats");
        System.out.println("22. Exit");
        System.out.println("============================================");
    }

    // ---------------- Input helpers (retry on invalid input) ----------------

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            int value = readInt(scanner, prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Error: value must be a positive integer.");
        }
    }

    private static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            double value = readDouble(scanner, prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Error: value must be greater than zero.");
        }
    }

    private static String readNonEmpty(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Error: value must not be empty.");
        }
    }

    private static String readNameWithoutDigits(Scanner scanner, String prompt) {
        while (true) {
            String name = readNonEmpty(scanner, prompt);
            if (!containsDigit(name)) {
                return name;
            }
            System.out.println("Error: name must not contain numeric characters.");
        }
    }

    private static int readAge(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int age = readInt(scanner, prompt);
            if (age >= min && age <= max) {
                return age;
            }
            System.out.println("Error: age must be between " + min + " and " + max + " years.");
        }
    }

    private static String readEmail(Scanner scanner, String prompt) {
        while (true) {
            String email = readNonEmpty(scanner, prompt);
            if (email.contains("@") && email.indexOf('@') == email.lastIndexOf('@')
                    && email.indexOf('@') > 0 && email.indexOf('@') < email.length() - 1
                    && email.substring(email.indexOf('@') + 1).contains(".")) {
                return email;
            }
            System.out.println("Error: email must have a valid basic format (e.g. name@mail.com).");
        }
    }

    private static String readPhone(Scanner scanner, String prompt) {
        while (true) {
            String phone = readNonEmpty(scanner, prompt);
            if (phone.length() == 10 && !containsDigitIsInvalid(phone)) {
                return phone;
            }
            System.out.println("Error: phone number must contain exactly 10 digits.");
        }
    }

    private static boolean containsDigitIsInvalid(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsDigit(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    // ---------------- Lookup helpers ----------------

    private static Bus findBusById(int busId) {
        for (Bus bus : buses) {
            if (bus.getBusId() == busId) {
                return bus;
            }
        }
        return null;
    }

    private static Bus findBusByPlateNumber(String plateNumber) {
        for (Bus bus : buses) {
            if (bus.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                return bus;
            }
        }
        return null;
    }

    private static Driver findDriverById(int driverId) {
        for (Driver driver : drivers) {
            if (driver.getDriverId() == driverId) {
                return driver;
            }
        }
        return null;
    }

    private static Driver findDriverByLicenseNumber(String licenseNumber) {
        for (Driver driver : drivers) {
            if (driver.getLicenseNumber().equalsIgnoreCase(licenseNumber)) {
                return driver;
            }
        }
        return null;
    }

    private static Route findRouteById(int routeId) {
        for (Route route : routes) {
            if (route.getRouteId() == routeId) {
                return route;
            }
        }
        return null;
    }

    private static Passenger findPassengerById(int passengerId) {
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerId() == passengerId) {
                return passenger;
            }
        }
        return null;
    }

    private static Passenger findPassengerByPhone(String phone) {
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerPhone().equals(phone)) {
                return passenger;
            }
        }
        return null;
    }

    private static Trip findTripById(int tripId) {
        for (Trip trip : trips) {
            if (trip.getTripId() == tripId) {
                return trip;
            }
        }
        return null;
    }

    private static Booking findBookingById(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        return null;
    }

    private static Payment findPaymentById(int paymentId) {
        for (Payment payment : payments) {
            if (payment.getPaymentId() == paymentId) {
                return payment;
            }
        }
        return null;
    }

    private static boolean hasActiveBooking(Passenger passenger, Trip trip) {
        for (Booking booking : bookings) {
            if (booking.getPassenger() == passenger && booking.getTrip() == trip
                    && "ACTIVE".equals(booking.getBookingStatus())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSeatTaken(Trip trip, int seatNumber) {
        for (Booking booking : bookings) {
            if (booking.getTrip() == trip && booking.getSeatNumber() == seatNumber
                    && "ACTIVE".equals(booking.getBookingStatus())) {
                return true;
            }
        }
        return false;
    }

    private static int countActiveBookings(Trip trip) {
        int count = 0;
        for (Booking booking : bookings) {
            if (booking.getTrip() == trip && "ACTIVE".equals(booking.getBookingStatus())) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasSuccessfulPayment(Booking booking) {
        for (Payment payment : payments) {
            if (payment.getBooking() == booking && "PAID".equals(payment.getPaymentStatus())) {
                return true;
            }
        }
        return false;
    }

    // ---------------- Registration ----------------

    private static void registerBus(Scanner scanner) {
        System.out.println("\n--- Register Bus ---");
        int busId = readPositiveInt(scanner, "Enter Bus ID: ");
        while (findBusById(busId) != null) {
            System.out.println("Error: Bus ID " + busId + " is already registered.");
            busId = readPositiveInt(scanner, "Enter Bus ID: ");
        }
        String plateNumber = readNonEmpty(scanner, "Enter Plate Number: ");
        while (findBusByPlateNumber(plateNumber) != null) {
            System.out.println("Error: plate number " + plateNumber + " is already registered.");
            plateNumber = readNonEmpty(scanner, "Enter Plate Number: ");
        }
        String busName = readNonEmpty(scanner, "Enter Bus Name: ");
        int seatCapacity = readPositiveInt(scanner, "Enter Seat Capacity: ");
        String busStatus = null;
        while (busStatus == null) {
            String input = readNonEmpty(scanner, "Enter Bus Status (AVAILABLE/UNAVAILABLE): ").toUpperCase();
            if (input.equals("AVAILABLE") || input.equals("UNAVAILABLE")) {
                busStatus = input;
            } else {
                System.out.println("Error: bus status must be AVAILABLE or UNAVAILABLE.");
            }
        }
        try {
            Bus bus = new Bus(busId, plateNumber, busName, seatCapacity, busStatus);
            buses.add(bus);
            System.out.println("Bus registered successfully.");
            System.out.println(bus);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registerDriver(Scanner scanner) {
        System.out.println("\n--- Register Driver ---");
        int driverId = readPositiveInt(scanner, "Enter Driver ID: ");
        while (findDriverById(driverId) != null) {
            System.out.println("Error: Driver ID " + driverId + " is already registered.");
            driverId = readPositiveInt(scanner, "Enter Driver ID: ");
        }
        String driverName = readNameWithoutDigits(scanner, "Enter Driver Name: ");
        String driverPhone = readNonEmpty(scanner, "Enter Driver Phone: ");
        String licenseNumber = readNonEmpty(scanner, "Enter License Number: ");
        while (findDriverByLicenseNumber(licenseNumber) != null) {
            System.out.println("Error: license number " + licenseNumber + " is already registered.");
            licenseNumber = readNonEmpty(scanner, "Enter License Number: ");
        }
        int driverAge = readAge(scanner, "Enter Driver Age: ", 21, 65);
        try {
            Driver driver = new Driver(driverId, driverName, driverPhone, licenseNumber, driverAge);
            drivers.add(driver);
            System.out.println("Driver registered successfully.");
            System.out.println(driver);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registerRoute(Scanner scanner) {
        System.out.println("\n--- Register Route ---");
        int routeId = readPositiveInt(scanner, "Enter Route ID: ");
        while (findRouteById(routeId) != null) {
            System.out.println("Error: Route ID " + routeId + " is already registered.");
            routeId = readPositiveInt(scanner, "Enter Route ID: ");
        }
        String departureLocation = readNonEmpty(scanner, "Enter Departure Location: ");
        String destinationLocation = readNonEmpty(scanner, "Enter Destination Location: ");
        while (departureLocation.equalsIgnoreCase(destinationLocation)) {
            System.out.println("Error: departure and destination locations must not be identical.");
            destinationLocation = readNonEmpty(scanner, "Enter Destination Location: ");
        }
        double distance = readPositiveDouble(scanner, "Enter Distance (km): ");
        double ticketPrice = readPositiveDouble(scanner, "Enter Ticket Price: ");
        try {
            Route route = new Route(routeId, departureLocation, destinationLocation, distance, ticketPrice);
            routes.add(route);
            System.out.println("Route registered successfully.");
            System.out.println(route);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registerPassenger(Scanner scanner) {
        System.out.println("\n--- Register Passenger ---");
        int passengerId = readPositiveInt(scanner, "Enter Passenger ID: ");
        while (findPassengerById(passengerId) != null) {
            System.out.println("Error: Passenger ID " + passengerId + " is already registered.");
            passengerId = readPositiveInt(scanner, "Enter Passenger ID: ");
        }
        String passengerName = readNameWithoutDigits(scanner, "Enter Passenger Name: ");
        String passengerEmail = readEmail(scanner, "Enter Passenger Email: ");
        int passengerAge = readAge(scanner, "Enter Passenger Age: ", 0, 120);
        String passengerPhone = readPhone(scanner, "Enter Passenger Phone (10 digits): ");
        while (findPassengerByPhone(passengerPhone) != null) {
            System.out.println("Error: phone number " + passengerPhone + " is already registered.");
            passengerPhone = readPhone(scanner, "Enter Passenger Phone (10 digits): ");
        }
        try {
            Passenger passenger = new Passenger(passengerId, passengerName, passengerEmail,
                    passengerAge, passengerPhone);
            passengers.add(passenger);
            System.out.println("Passenger registered successfully.");
            System.out.println(passenger);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ---------------- Trip scheduling ----------------

    private static void scheduleTrip(Scanner scanner) {
        System.out.println("\n--- Schedule Trip ---");
        if (buses.isEmpty() || drivers.isEmpty() || routes.isEmpty()) {
            System.out.println("Error: buses, drivers and routes must be registered before scheduling a trip.");
            return;
        }
        int tripId = readPositiveInt(scanner, "Enter Trip ID: ");
        while (findTripById(tripId) != null) {
            System.out.println("Error: Trip ID " + tripId + " already exists.");
            tripId = readPositiveInt(scanner, "Enter Trip ID: ");
        }
        Bus bus = null;
        while (bus == null) {
            int busId = readPositiveInt(scanner, "Enter Bus ID: ");
            bus = findBusById(busId);
            if (bus == null) {
                System.out.println("Error: bus with ID " + busId + " is not registered.");
            } else if (!"AVAILABLE".equals(bus.getBusStatus())) {
                System.out.println("Error: only available buses may be assigned to trips. Bus "
                        + bus.getPlateNumber() + " is " + bus.getBusStatus() + ".");
                bus = null;
            }
        }
        Driver driver = null;
        while (driver == null) {
            int driverId = readPositiveInt(scanner, "Enter Driver ID: ");
            driver = findDriverById(driverId);
            if (driver == null) {
                System.out.println("Error: driver with ID " + driverId + " is not registered.");
            }
        }
        Route route = null;
        while (route == null) {
            int routeId = readPositiveInt(scanner, "Enter Route ID: ");
            route = findRouteById(routeId);
            if (route == null) {
                System.out.println("Error: route with ID " + routeId + " is not registered.");
            }
        }
        String departureTime = null;
        while (departureTime == null) {
            String time = readNonEmpty(scanner, "Enter Departure Time: ");
            if (isBusBookedAt(bus, time)) {
                System.out.println("Error: bus " + bus.getPlateNumber()
                        + " is already assigned to another trip at " + time + ".");
            } else if (isDriverBookedAt(driver, time)) {
                System.out.println("Error: driver " + driver.getDriverName()
                        + " is already assigned to another trip at " + time + ".");
            } else {
                departureTime = time;
            }
        }
        try {
            Trip trip = new Trip(tripId, bus, driver, route, departureTime);
            trips.add(trip);
            System.out.println("Trip scheduled successfully.");
            System.out.println(trip);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean isBusBookedAt(Bus bus, String departureTime) {
        for (Trip trip : trips) {
            if (trip.getBus() == bus && trip.getDepartureTime().equalsIgnoreCase(departureTime)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDriverBookedAt(Driver driver, String departureTime) {
        for (Trip trip : trips) {
            if (trip.getDriver() == driver && trip.getDepartureTime().equalsIgnoreCase(departureTime)) {
                return true;
            }
        }
        return false;
    }

    // ---------------- Booking ----------------

    private static void bookTicket(Scanner scanner) {
        System.out.println("\n--- Book Ticket ---");
        if (passengers.isEmpty()) {
            System.out.println("Error: no registered passengers found. Register a passenger first.");
            return;
        }
        if (trips.isEmpty()) {
            System.out.println("Error: no scheduled trips found. Schedule a trip first.");
            return;
        }
        int bookingId = readPositiveInt(scanner, "Enter Booking ID: ");
        while (findBookingById(bookingId) != null) {
            System.out.println("Error: Booking ID " + bookingId + " already exists.");
            bookingId = readPositiveInt(scanner, "Enter Booking ID: ");
        }
        Passenger passenger = null;
        while (passenger == null) {
            int passengerId = readPositiveInt(scanner, "Enter Passenger ID: ");
            passenger = findPassengerById(passengerId);
            if (passenger == null) {
                System.out.println("Error: passenger with ID " + passengerId + " is not registered.");
            }
        }
        Trip trip = null;
        while (trip == null) {
            int tripId = readPositiveInt(scanner, "Enter Trip ID: ");
            trip = findTripById(tripId);
            if (trip == null) {
                System.out.println("Error: trip with ID " + tripId + " is not scheduled.");
            }
        }
        if (hasActiveBooking(passenger, trip)) {
            System.out.println("Error: passenger " + passenger.getPassengerName()
                    + " already has an active booking for trip " + trip.getTripId() + ".");
            return;
        }
        int capacity = trip.getBus().getSeatCapacity();
        if (countActiveBookings(trip) >= capacity) {
            System.out.println("Error: trip " + trip.getTripId() + " is fully booked.");
            return;
        }
        int seatNumber = readPositiveInt(scanner, "Enter Seat Number (1 - " + capacity + "): ");
        while (seatNumber > capacity) {
            System.out.println("Error: seat number must be between 1 and " + capacity + ".");
            seatNumber = readPositiveInt(scanner, "Enter Seat Number (1 - " + capacity + "): ");
        }
        while (isSeatTaken(trip, seatNumber)) {
            System.out.println("Error: seat " + seatNumber + " is already reserved on trip "
                    + trip.getTripId() + ".");
            seatNumber = readPositiveInt(scanner, "Enter Seat Number (1 - " + capacity + "): ");
        }
        try {
            Booking booking = new Booking(bookingId, passenger, trip, seatNumber, "ACTIVE");
            bookings.add(booking);
            System.out.println("Booking created successfully. Seat " + seatNumber + " reserved.");
            System.out.println(booking);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void cancelBooking(Scanner scanner) {
        System.out.println("\n--- Cancel Booking ---");
        if (bookings.isEmpty()) {
            System.out.println("Error: no bookings found.");
            return;
        }
        Booking booking = null;
        while (booking == null) {
            int bookingId = readPositiveInt(scanner, "Enter Booking ID: ");
            booking = findBookingById(bookingId);
            if (booking == null) {
                System.out.println("Error: booking with ID " + bookingId + " does not exist.");
            }
        }
        if ("CANCELLED".equals(booking.getBookingStatus())) {
            System.out.println("Error: booking " + booking.getBookingId() + " has already been cancelled.");
            return;
        }
        booking.setBookingStatus("CANCELLED");
        System.out.println("Booking " + booking.getBookingId() + " cancelled successfully. Seat "
                + booking.getSeatNumber() + " has been released.");
    }

    // ---------------- Payment ----------------

    private static void processPayment(Scanner scanner) {
        System.out.println("\n--- Process Payment ---");
        if (bookings.isEmpty()) {
            System.out.println("Error: no bookings found. Create a booking first.");
            return;
        }
        int paymentId = readPositiveInt(scanner, "Enter Payment ID: ");
        while (findPaymentById(paymentId) != null) {
            System.out.println("Error: Payment ID " + paymentId + " already exists.");
            paymentId = readPositiveInt(scanner, "Enter Payment ID: ");
        }
        Booking booking = null;
        while (booking == null) {
            int bookingId = readPositiveInt(scanner, "Enter Booking ID: ");
            booking = findBookingById(bookingId);
            if (booking == null) {
                System.out.println("Error: booking with ID " + bookingId + " does not exist.");
            }
        }
        if (!"ACTIVE".equals(booking.getBookingStatus())) {
            System.out.println("Error: payment can only be processed for an ACTIVE booking. Booking "
                    + booking.getBookingId() + " is " + booking.getBookingStatus() + ".");
            return;
        }
        if (hasSuccessfulPayment(booking)) {
            System.out.println("Error: booking " + booking.getBookingId()
                    + " already has a successful payment. Duplicate payments are not allowed.");
            return;
        }
        String paymentMethod = null;
        while (paymentMethod == null) {
            String input = readNonEmpty(scanner, "Enter Payment Method (CASH / MOBILE MONEY / CARD): ")
                    .toUpperCase();
            if (input.equals("CASH") || input.equals("MOBILE MONEY") || input.equals("CARD")) {
                paymentMethod = input;
            } else {
                System.out.println("Error: unsupported payment method. Choose CASH, MOBILE MONEY or CARD.");
            }
        }
        double requiredAmount = booking.getTrip().getRoute().getTicketPrice();
        double amountPaid = readDouble(scanner,
                "Enter Amount Paid (Ticket Price: " + requiredAmount + "): ");
        if (amountPaid <= 0) {
            System.out.println("Error: payment amount must be greater than zero. Payment not recorded.");
            return;
        }
        if (Math.abs(amountPaid - requiredAmount) < 0.0001) {
            Payment payment = new Payment(paymentId, booking, amountPaid, paymentMethod, "PAID");
            payments.add(payment);
            System.out.println("Payment processed successfully.");
            System.out.println(payment);
        } else {
            Payment payment = new Payment(paymentId, booking, amountPaid, paymentMethod, "FAILED");
            payments.add(payment);
            System.out.println("Error: payment amount must equal the ticket price of " + requiredAmount
                    + ". Payment recorded as FAILED.");
        }
    }

    // ---------------- View all ----------------

    private static void viewAllBuses() {
        System.out.println("\n--- All Buses ---");
        if (buses.isEmpty()) {
            System.out.println("No registered buses found.");
            return;
        }
        for (Bus bus : buses) {
            System.out.println(bus);
        }
    }

    private static void viewAllDrivers() {
        System.out.println("\n--- All Drivers ---");
        if (drivers.isEmpty()) {
            System.out.println("No registered drivers found.");
            return;
        }
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }

    private static void viewAllRoutes() {
        System.out.println("\n--- All Routes ---");
        if (routes.isEmpty()) {
            System.out.println("No registered routes found.");
            return;
        }
        for (Route route : routes) {
            System.out.println(route);
        }
    }

    private static void viewAllPassengers() {
        System.out.println("\n--- All Passengers ---");
        if (passengers.isEmpty()) {
            System.out.println("No registered passengers found.");
            return;
        }
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
    }

    private static void viewAllTrips() {
        System.out.println("\n--- All Scheduled Trips ---");
        if (trips.isEmpty()) {
            System.out.println("No scheduled trips found.");
            return;
        }
        for (Trip trip : trips) {
            System.out.println(trip);
        }
    }

    private static void viewAllBookings() {
        System.out.println("\n--- All Bookings ---");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    private static void viewAllPayments() {
        System.out.println("\n--- All Payments ---");
        if (payments.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }
        for (Payment payment : payments) {
            System.out.println(payment);
        }
    }

    // ---------------- Search ----------------

    private static void searchBusByPlateNumber(Scanner scanner) {
        System.out.println("\n--- Search Bus by Plate Number ---");
        if (buses.isEmpty()) {
            System.out.println("No registered buses found.");
            return;
        }
        String plateNumber = readNonEmpty(scanner, "Enter Plate Number: ");
        boolean found = false;
        for (Bus bus : buses) {
            if (bus.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                System.out.println(bus);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No bus found with plate number " + plateNumber + ".");
        }
    }

    private static void searchDriverByLicenseNumber(Scanner scanner) {
        System.out.println("\n--- Search Driver by License Number ---");
        if (drivers.isEmpty()) {
            System.out.println("No registered drivers found.");
            return;
        }
        String licenseNumber = readNonEmpty(scanner, "Enter License Number: ");
        boolean found = false;
        for (Driver driver : drivers) {
            if (driver.getLicenseNumber().equalsIgnoreCase(licenseNumber)) {
                System.out.println(driver);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No driver found with license number " + licenseNumber + ".");
        }
    }

    private static void searchPassengerByPhoneNumber(Scanner scanner) {
        System.out.println("\n--- Search Passenger by Phone Number ---");
        if (passengers.isEmpty()) {
            System.out.println("No registered passengers found.");
            return;
        }
        String phone = readNonEmpty(scanner, "Enter Passenger Phone Number: ");
        boolean found = false;
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerPhone().equals(phone)) {
                System.out.println(passenger);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No passenger found with phone number " + phone + ".");
        }
    }

    private static void searchTripByTripId(Scanner scanner) {
        System.out.println("\n--- Search Trip by Trip ID ---");
        if (trips.isEmpty()) {
            System.out.println("No scheduled trips found.");
            return;
        }
        int tripId = readPositiveInt(scanner, "Enter Trip ID: ");
        boolean found = false;
        for (Trip trip : trips) {
            if (trip.getTripId() == tripId) {
                System.out.println(trip);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No trip found with Trip ID " + tripId + ".");
        }
    }

    private static void searchBookingByBookingId(Scanner scanner) {
        System.out.println("\n--- Search Booking by Booking ID ---");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        int bookingId = readPositiveInt(scanner, "Enter Booking ID: ");
        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                System.out.println(booking);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No booking found with Booking ID " + bookingId + ".");
        }
    }

    // ---------------- Available seats ----------------

    private static void checkAvailableSeats(Scanner scanner) {
        System.out.println("\n--- Check Available Seats ---");
        if (trips.isEmpty()) {
            System.out.println("No scheduled trips found.");
            return;
        }
        int tripId = readPositiveInt(scanner, "Enter Trip ID: ");
        Trip trip = null;
        while (trip == null) {
            trip = findTripById(tripId);
            if (trip == null) {
                System.out.println("Error: trip with ID " + tripId + " is not scheduled.");
                tripId = readPositiveInt(scanner, "Enter Trip ID: ");
            }
        }
        int capacity = trip.getBus().getSeatCapacity();
        int bookedCount = countActiveBookings(trip);
        System.out.println("Trip " + trip.getTripId() + " (" + trip.getRoute().getDepartureLocation()
                + " -> " + trip.getRoute().getDestinationLocation() + ") on bus "
                + trip.getBus().getPlateNumber() + ", departure " + trip.getDepartureTime());
        System.out.println("Seat Capacity : " + capacity);
        System.out.println("Booked Seats  : " + bookedCount);
        System.out.println("Available Seats: " + (capacity - bookedCount));
        System.out.print("Free Seat Numbers: ");
        boolean anyFree = false;
        for (int seat = 1; seat <= capacity; seat++) {
            if (!isSeatTaken(trip, seat)) {
                System.out.print(seat + " ");
                anyFree = true;
            }
        }
        if (!anyFree) {
            System.out.print("None");
        }
        System.out.println();
    }
}
