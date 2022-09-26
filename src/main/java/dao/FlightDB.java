package dao;
import data.Flight;
import java.io.IOException;
import java.util.ArrayList;

public class FlightDB {
    public FlightDB() throws IOException{
        FlightReader reader = new FlightReader();
        ArrayList<Flight> db = (ArrayList<Flight>) reader.read();
        flightArrayList = db;
    }

    private ArrayList<Flight> flightArrayList;
    public ArrayList<Flight> getFlightArrayList(){
        return flightArrayList;
    }

    public Flight getFlight(int id){
        for(Flight flight : flightArrayList){
            if(flight.getId() == id) return flight;
        }
        throw new IllegalArgumentException("No flight with such ID");
    }

    public boolean update(Flight flight){
        for(Flight value : flightArrayList){
            if(value.getId() == flight.getId()){
                value.setSeats(flight.getSeats());
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        return flightArrayList.toString().replace("[", "").replace("]", "").replace(",", "").replace(",", "");
    }
}
