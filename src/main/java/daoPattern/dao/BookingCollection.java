package daoPattern.dao;

import daoPattern.model.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static daoPattern.dao.FlightCollection.flightsFromDB;

public class BookingCollection implements BookingDao {
    static FlightCollection flightCollection = new FlightCollection();
    public List<Flight> flights = new ArrayList<>();
    public static Map<String, Integer> flightSeatsAfterBook = new HashMap<>();
    public List<String> bookedFlights = new ArrayList<>();
    public void getAll() {

    }
    public static Map<String, Integer> flightSeatsAfterBooking() throws IOException {
        flightCollection.getAll();
        for (int i=0; i<31; i++) {
            flightSeatsAfterBook.put(flightsFromDB.get(i).substring(0, flightsFromDB.get(i).length()-3), Integer.valueOf(flightsFromDB.get(i).substring(flightsFromDB.get(i).length()-3, flightsFromDB.get(i).length()-1+1)));
        }
        return flightSeatsAfterBook;
    }


    public static void bookFlight() throws IOException {

        String fileName = "book.txt";
        File file = new File(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        // writer.write(String.valueOf(loginMap));
        writer.close();
    }

    public List<String> getBookedFlights() throws IOException {
        String fileName = "booksList.txt";
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;


            while ((line = br.readLine()) != null) {

                bookedFlights.add(line);

            }
            return bookedFlights;
        }
    }

}
