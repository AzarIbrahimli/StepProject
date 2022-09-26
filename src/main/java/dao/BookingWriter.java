package dao;
import data.Booking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BookingWriter {
    public void write(List<Booking> origin) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/main/java/database/bookings.txt")));
        writer.flush();
        writer.close();
    }
}
