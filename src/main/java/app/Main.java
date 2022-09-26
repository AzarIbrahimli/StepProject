package app;
import controller.BookingController;
import controller.FlightController;
import data.User;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void run() throws IOException {
        FlightController flightController = new FlightController();
        BookingController bookingController = new BookingController();
        Scanner sc = new Scanner(System.in);
        boolean q = false;
        int choice;
        int item;
        int id;
        String destination;
        int seats;
        String name;
        String surname;
        System.out.println("    Booking Application \n");
        System.out.print("Full name : ");
        name = sc.next();
        surname = sc.next();
        User user = new User(name, surname);
        do{
            Menu.menu();
            System.out.print("Choose operation, please: ");
            item = sc.nextInt();
            switch(item){
                case 1:
                    System.out.println("\n    Online-Board \n");
                    System.out.println("====================================================");
                    flightController.getOnlineBoard();
                    System.out.println("====================================================");
                    break;
                case 2:
                    System.out.println("\n    Show the Flight Info \n");
                    System.out.print("Flight ID : ");
                    id = sc.nextInt();
                    System.out.println("====================================================");
                    flightController.getFlightInfo(id);
                    System.out.println("====================================================");
                    break;
                case 3:
                    System.out.println("\n    Search a Flight \n");
                    System.out.print("Destination and number of Ticket : ");
                    destination = sc.next();
                    seats = sc.nextInt();
                    System.out.println("====================================================");
                    flightController.search(destination, seats);
                    System.out.println("====================================================");
                    System.out.println("0.    Main Menu        |    1.     Continue Booking \n");
                    choice = sc.nextInt();
                    if(choice==0){
                        break;
                    }
                    System.out.println("\n    Book a Flight \n");
                    System.out.print("Please enter flight-ID and number of Ticket :");
                    id = sc.nextInt();
                    seats = sc.nextInt();
                    System.out.println("====================================================");
                    bookingController.book(user,id,seats);
                    System.out.println("====================================================");
                    break;
                case 4:
                    System.out.println("\n    Cancel the Booking \n");
                    System.out.print("Booking ID : ");
                    id = sc.nextInt();
                    System.out.println("====================================================");
                    bookingController.cancel(id);
                    System.out.println("====================================================");
                    break;
                case 5:
                    System.out.println("\n    My Flights \n");
                    System.out.println("====================================================");
                    bookingController.myflights(user);
                    System.out.println("====================================================");
                    break;
                case 6:
                    System.out.println("====================================================");
                    System.out.println("Booking App closing ...");
                    System.out.println("====================================================");
                    q= true;
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }while(!q);
    }
}
