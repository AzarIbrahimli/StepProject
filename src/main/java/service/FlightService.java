package service;

import dao.FlightDB;
import data.Flight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class FlightService {
    public FlightDB flightDB;

    public FlightService() throws IOException {
        flightDB = new FlightDB();
    }

    public String getOnlineBoard(){
        return flightDB.toString();
    }

    public String getFlightInfo(int id){
        return flightDB.getFlight(id).toString().replace("[", "").replace("]", "").replace(",", "").replace(",", "");
    }

    public Flight getFlightByID(int id){
        return flightDB.getFlight(id);
    }

    public String search(String destination, int seats){
        List<Flight> result = new LinkedList<>();
        ArrayList<Flight> database = flightDB.getFlightArrayList();
        for (Flight flight : database){
            if(flight.getDestination().toLowerCase().equals(destination.toLowerCase()) && flight.getSeats() >= seats){
                result.add(flight);
            }
        }
        return  result.toString().replace("[", "").replace("]", "").replace(",", "").replace(",", "");
    }
}
