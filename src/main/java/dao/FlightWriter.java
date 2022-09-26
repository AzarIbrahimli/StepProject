package dao;
import data.Flight;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FlightWriter {
    public void write(List<Flight> origin) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/main/java/database/flights.txt")));
        writer.flush();
        writer.close();
    }
}
