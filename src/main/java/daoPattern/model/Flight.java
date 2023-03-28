package daoPattern.model;

public class Flight {
    public Integer id;
    String time;
    public String from = "KIEV - UKRAINE";
    Object to;
    public Integer seats;

    public  Flight (Integer id, String time, String from, Object to, Integer seats) {
        this.id = id;
        this.time = time;
        this.from = from;
        this.to = to;
        this.seats = seats;
    }

    public Flight() {

    }

    @Override
    public String toString () {
        return id + " " + time + " " +from + " " +to + " " +seats + "\n";
    }
}

