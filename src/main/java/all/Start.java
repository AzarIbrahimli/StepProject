package all;

import daoPattern.controller.BookingController;
import daoPattern.controller.FlightController;
import daoPattern.dao.FlightCollection;

import java.io.IOException;
import java.util.Scanner;

public class Start {
    public static void start() throws IOException {

        FlightController flightController = new FlightController();
        FlightCollection flightCollection = new FlightCollection();
        BookingController bookingController = new BookingController();
        FlightController.createFlights();
        Scanner sc = new Scanner(System.in);

        System.out.println("                   ==BOOKING APP==");
        System.out.println("          Choose the number of action below for continue app:");
        System.out.println("1 - Online board                    ||     2 - Show the flight info");
        System.out.println("3 - Search and book a flight        ||     4 - Cancel the booking");
        System.out.println("5 - My flights                      ||     6 - Exit");

        int menu = sc.nextInt();

        switch (menu) {
            case 1:
                flightCollection.showAllFlights();
                start();
                break;
            case 2:
                flightController.showFlightInfo();
                start();
                break;
            case 3:
                bookingController.searchAndBook();
                start();
                break;
            case 4:
                bookingController.cancelBooking();
                start();
                break;
            case 5:
                bookingController.viewMyFlights();
                start();
                break;
            case 6:
                System.exit(0);
        }
    }
}
