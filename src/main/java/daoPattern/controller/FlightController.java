package daoPattern.controller;

import daoPattern.dao.BookingCollection;
import daoPattern.dao.FlightCollection;
import daoPattern.model.Flight;
import daoPattern.service.FlightService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.valueOf;


public class FlightController {

    static FlightService flightService = new FlightService();
    static FlightCollection flightCollection = new FlightCollection();
    static Flight flight = new Flight();
    static BookingCollection bookingCollection = new BookingCollection();

    static List<Flight> flights = new ArrayList<>();
    int index;


    public static void createFlights() throws IOException {
        flightCollection.destination();
        flight.id = 101;
        flight.seats = 180;
        String fileName = "flightsList.txt";
        File file = new File(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));


        for (
                Object destination : flightCollection.destinationCity) {

            Flight f = new Flight(flight.id, flightService.randomTime(), flight.from, destination, flight.seats);
            flights.add(f);
            bookingCollection.flights.add(f);
            writer.write(valueOf(f));
            flight.id++;
            System.out.println(f);
        }
        writer.close();
        // System.out.println(flightCollection.destinationCity);
    }


    public void showFlightInfo() throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter ID of flight");

        int inputtedID = sc.nextInt();
        flightCollection.getAll();

        switch (inputtedID) {
            case 101:
                index = 0;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 102:
                index = 1;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 103:
                index = 2;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 104:
                index = 3;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 105:
                index = 4;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 106:
                index = 5;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 107:
                index = 6;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 108:
                index = 7;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 109:
                index = 8;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 110:
                index = 9;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 111:
                index = 10;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 112:
                index = 11;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 113:
                index = 12;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 114:
                index = 13;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 115:
                index = 14;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 116:
                index = 15;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 117:
                index = 16;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 118:
                index = 17;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 119:
                index = 18;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 120:
                index = 19;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 121:
                index = 20;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 122:
                index = 21;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 123:
                index = 22;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 124:
                index = 23;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 125:
                index = 24;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 126:
                index = 25;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 127:
                index = 26;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 128:
                index = 27;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 129:
                index = 28;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 130:
                index = 29;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            case 131:
                index = 30;
                System.out.println(flightCollection.flightsFromDB.get(index));
                break;
            default:
                System.out.println("Please enter valid ID");
        }


    }


}
