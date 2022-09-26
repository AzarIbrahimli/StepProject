package data;
import java.util.Objects;
public class Flight {
    private int hour;
    private int min;
    private int day;
    private int month;
    private int year;
    private String destination;
    private int id;
    private int seats;
    private final String starting = "Kiev(UKR)";

    public Flight(int day, int month, int year,int hour, int min,  String destination, int seats) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
        this.destination = destination;
        this.seats = seats;
    }
    public Flight(int id,String destination, int day, int month, int year,int hour, int min,int seats) {
        this.id = id;
        this.destination = destination;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
        this.seats = seats;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public int getDay() {
        return day;
    }


    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getStarting() {
        return starting;
    }

    public String getDestination() {
        return destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void book(int seats){
        this.seats = this.seats - seats;
    }

    @Override
    public String toString(){
        return String.format("\n%d) %s -> %s | Date : %d/%d/%d | Time: %d:%d | Available: %d seats | \n",
                id,starting,destination,day,month,year,hour,min,seats);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return hour == flight.hour &&
                min == flight.min &&
                day == flight.day &&
                month == flight.month &&
                year == flight.year &&
                id == flight.id &&
                seats == flight.seats &&
                Objects.equals(destination, flight.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, min, day, month, year, destination, id, seats);
    }
}
