package service;
import dao.*;
import data.Booking;
import data.Flight;
import data.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    public FlightDB flightDB;
    public BookingDB bookingDB;
    public FlightService flightService;

    public BookingService() throws IOException {
        flightDB = new FlightDB();
        bookingDB = new BookingDB();
        flightService = new FlightService();
    }

    public String book(User user, int id, int seats) throws IOException {
        Flight flight = flightService.getFlightByID(id);
        flight.book(seats);
        if(flightService.flightDB.update(flight)) {
            FlightWriter writer = new FlightWriter();
            writer.write(flightService.flightDB.getFlightArrayList());
            bookingDB.add(new Booking(user, flight, bookingDB.getLastId() +1));
            BookingWriter bookingWriter = new BookingWriter();
            bookingWriter.write(bookingDB.getDatabase());
            return "Booked Successfully";
        }
        return "No such ID";
    }

    public String cancelBooking(int id) throws IOException {
        List<Booking> bookingList = bookingDB.getDatabase();
        for(int i=0; i<bookingList.size();i++){
            if(bookingList.get(i).getId() == id){
                bookingList.remove(bookingList.get(i));
                BookingWriter writer = new BookingWriter();
                writer.write(bookingList);
                return "Book has been canceled.";
            }
        }
        return "ID not found";
    }

    public String getMyFlights(User u){
        String a;
        List<Booking> database = bookingDB.getDatabase();
        ArrayList<Booking> bookings = new ArrayList<>();
        for(Booking booking : database){
            if(booking.getUser().equals(u)){
                bookings.add(booking);
            }
        }
        if (bookings.isEmpty()) {
            a="There is not any booking";
        }
        else{
            a = bookings.toString().replace("[", "").replace("]", "").replace(",", "").replace(",", "");;
        }
        return a;
    }


}
