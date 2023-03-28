package daoPattern.controller;

import all.Login;
import daoPattern.dao.BookingCollection;
import daoPattern.dao.FlightCollection;
import daoPattern.model.Booking;
import daoPattern.service.BookingService;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

import static java.lang.String.valueOf;

public class BookingController {
    BookingService bookingService = new BookingService();
    Booking booking = new Booking();
    static BookingCollection bookingCollection = new BookingCollection();
    FlightCollection flightCollection = new FlightCollection();
    static Login login = new Login();
    Map<StringBuilder, StringBuilder> passengers = new HashMap<StringBuilder, StringBuilder>();


    static Scanner sc = new Scanner(System.in);

    public void searchAndBook() throws IOException {

        flightCollection.getAll();


        System.out.println("Please enter destination city (with uppercase):");
        String destinationPoint = sc.nextLine();

        System.out.println("Please enter flight date (dd.mm.yyyy):");
        String date = sc.nextLine();

        System.out.println("Please enter number of people (how many tickets to buy):");
        int tickets = sc.nextInt();
        //  System.out.println(FlightCollection.flightsFromDB);
        for (int i = 0; i < 31; i++) {

            if (flightCollection.flightsFromDB.get(i).contains(destinationPoint) && flightCollection.flightsFromDB.get(i).contains(date)) {
                System.out.println(flightCollection.flightsFromDB.get(i));


                System.out.println("Select flight ID from above for booking:");
                int bookID = sc.nextInt();
                flightCollection.withSeats();
                for (Map.Entry<String, Integer> entry : flightCollection.flightsWithSeats.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();

                    if (key.contains(valueOf(bookID))) {
                        StringBuilder sb = new StringBuilder();
                        bookingCollection.flightSeatsAfterBook.remove(key);
                        value -= tickets;
                        bookingCollection.flightSeatsAfterBook.put(key, value);
                        sb.append(key);
                        sb.append(", ");
                        sb.append(value);
                        sb.append("\n");


                        for (int j = 0; j < tickets; j++) {
                            StringBuilder names = new StringBuilder();
                            String fullName = sc.nextLine();
                            System.out.println("Please, enter passenger name and surname:");
                            names.append(login.usernames.get(0));
                            names.append(", ");
                            names.append(fullName);
                            passengers.put(names, sb);
                        }
                        StringBuilder names = new StringBuilder();
                        String fullName = sc.nextLine();
                        names.append(login.usernames.get(0));
                        names.append(", ");
                        names.append(fullName);
                        passengers.put(names, sb);

                        String fileName = "booksList.txt";
                        File file = new File(fileName);
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        writer.write(String.valueOf(passengers));
                        writer.close();

                        System.out.println(key + value);
                    }
                }
                String fileName = "book.txt";
                File file = new File(fileName);
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(String.valueOf(FlightCollection.flightsWithSeats));
                writer.close();
            }
        }
    }

    public static void viewMyFlights() throws IOException {
        bookingCollection.getBookedFlights();
        System.out.println("Input passenger name for finding flight:");
        String passenger = sc.nextLine();
        for (int i = 0; i < bookingCollection.bookedFlights.size(); i++) {
            if (bookingCollection.bookedFlights.get(i).contains(login.usernames.get(0)) && bookingCollection.bookedFlights.get(i).contains(passenger)) {
                String[] myFlight = bookingCollection.bookedFlights.get(i).split("=", 2);
                for (int j = 1; j < myFlight.length; j++) {
                    if (j % 2 == 1) {
                        System.out.println(myFlight[j]);
                    }
                }
            }
        }
    }

    public static void cancelBooking() throws IOException {
        //  List<String> temp = new ArrayList<>();

        System.out.println("Please, enter flight ID to cancel:");
        String cancelID = sc.nextLine();

        File file = new File("booksList.txt");
        File temp = new File("myTempFile.txt");

        PrintWriter out = new PrintWriter(new FileWriter(temp));
        Files.lines(file.toPath())
                .filter(line -> !line.contains(cancelID))
                .forEach(out::println);
        out.flush();
        out.close();
        try{

            FileWriter fw = new FileWriter(file, false);

            PrintWriter pw = new PrintWriter(fw, false);

            pw.flush();

            pw.close();

            fw.close();

        }catch(Exception exception){

            System.out.println("Exception have been caught");

        }
        file.renameTo(temp);


//        String fileName = "booksList.txt";
//        String tempfile = "myTempFile.txt";
//        File file = new File(fileName);
//
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(line);
//                sb.append("\n");
//                temp.add(String.valueOf(sb));
//
//            }
//        }
//        for (int i=0; i<temp.size(); i++){
//        if (temp.get(i).contains(cancelID) && temp.get(i).contains(login.usernames.get(0))) {
//        temp.remove(i);
//        }
//        }
//        File myTempFile = new File(tempfile);
//        BufferedWriter writer = new BufferedWriter(new FileWriter(myTempFile));
//        writer.write(String.valueOf(temp));
//
//        writer.close();
//        boolean successful = myTempFile.renameTo(file);
    }
}