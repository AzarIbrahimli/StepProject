package data;

public class Booking {
    private User user;
    private Flight flight;
    private int id;


    public Booking(User user, Flight flight, int id) {
        this.user = user;
        this.flight = flight;
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return String.format("\n%d) %s %s | %s -> %s | Date : %d/%d/%d | Time: %d:%d | Available: %d seats | \n",
                id,user.getName(),user.getSurname(),
                flight.getStarting(), flight.getDestination(), flight.getDay(), flight.getMonth(), flight.getYear(), flight.getHour(), flight.getMin(), flight.getSeats());
    }
}
