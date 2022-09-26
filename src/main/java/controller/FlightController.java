package controller;
import service.FlightService;
import java.io.IOException;

public class FlightController {
    FlightService flightService;

    public FlightController() throws IOException {
        flightService = new FlightService();
    }

    public void getOnlineBoard() {
        System.out.println(flightService.getOnlineBoard());
    }

    public void getFlightInfo(int id) {
        System.out.println(flightService.getFlightInfo(id));
    }

    public void search(String destination, int seats) {
        System.out.println(flightService.search(destination, seats));

    }
}
