package controller;
import data.User;
import service.BookingService;
import java.io.IOException;
public class BookingController {
    BookingService bookingService;

    public BookingController() throws IOException {
        bookingService = new BookingService();
    }
    public void book(User user, int id, int seats) throws IOException {
        System.out.println(bookingService.book(user,id,seats));
    }

    public void cancel(int id) throws IOException {
        System.out.println(bookingService.cancelBooking(id));
    }
    public void myflights(User user){
        System.out.println(bookingService.getMyFlights(user));
    }
}
