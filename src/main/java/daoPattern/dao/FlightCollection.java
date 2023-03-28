package daoPattern.dao;

import enums.City;
import enums.Country;

import java.io.*;
import java.util.*;

import static enums.City.*;
import static enums.Country.*;

public class FlightCollection implements FlightDao {

    public Map<City, Country> to = new HashMap<>();
    public List<Object> destinationCity = new ArrayList<>();
    public static ArrayList<String> flightsFromDB = new ArrayList<>();
    static ArrayList<String> singleFlight = new ArrayList<>();
    public static Map<String, Integer> flightsWithSeats = new HashMap<>();

    public List<Object> destination() {
        to.put(BAKU, AZERBAIJAN);
        to.put(VIENNA, AUSTRIA);
        to.put(BRUSSELS, BELGIUM);
        to.put(TORONTO, CANADA);
        to.put(PULA, CROATIA);
        to.put(SPLIT, CROATIA);
        to.put(LARNACA, CYPRUS);
        to.put(PRAGUE, CZECHIA);
        to.put(COPANHAGEN, DENMARK);
        to.put(CAIRO, EGYPT);
        to.put(PARIS, FRANCE);
        to.put(TBILISI, GEORGIA);
        to.put(DUSSELDORF, GERMANY);
        to.put(MUNICH, GERMANY);
        to.put(ATHENS, GREECE);
        to.put(BUDAPEST, HUNGARY);
        to.put(NEW_DELHI, INDIA);
        to.put(TEL_AVIV, ISRAEL);
        to.put(ROME, ITALY);
        to.put(MILAN, ITALY);
        to.put(TIVAT, MONTENEGRO);
        to.put(AMSTERDAM, NETHERLAND);
        to.put(OSLO, NORWAY);
        to.put(WARSAW, POLAND);
        to.put(BARCELONA, SPAIN);
        to.put(MADRID, SPAIN);
        to.put(STOCKOLM, SWEDEN);
        to.put(GENEVA, SWITZERLAND);
        to.put(ZURICH, SWITZERLAND);
        to.put(LONDON, UK);
        to.put(ISTANBUL, TURKIYE);

        for (
                Map.Entry<City, Country> entry : to.entrySet()) {

            City key = entry.getKey();
            Country value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(key);
            sb.append(" - ");
            sb.append(value);
            destinationCity.add(sb);
        }
        return destinationCity;

    }

    public static ArrayList<String> getAll() throws IOException {

        String fileName = "flightsList.txt";
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;


            while ((line = br.readLine()) != null) {

                flightsFromDB.add(line);

            }
            return flightsFromDB;
        }
    }

    public static void showAllFlights() throws IOException {

        String fileName = "flightsList.txt";
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;


            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        }
    }

    public static void withSeats() {
        try {
            getAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i=0; i<31; i++) {
            flightsWithSeats.put(flightsFromDB.get(i).substring(0, flightsFromDB.get(i).length()-3), Integer.valueOf(flightsFromDB.get(i).substring(flightsFromDB.get(i).length()-3, flightsFromDB.get(i).length()-1+1)));
        }
    }




}