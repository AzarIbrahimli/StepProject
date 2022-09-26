package dao;
import data.Booking;
import java.io.IOException;
import java.util.List;

public class BookingDB {
    private List<Booking> database;

    public BookingDB(List<Booking> database) {
        this.database = database;
    }

    public BookingDB() throws IOException {
        BookingReader reader = new BookingReader();
        database = reader.read();
    }
    public List<Booking> getDatabase(){
        return database;
    }

    public void add(Booking data){
        database.add(data);
    }
    public int getLastId(){
        if(!database.isEmpty()){
            return database.get(database.size() - 1).getId();
        }
        return 0;
    }

}
