package dao;
import data.Booking;
import data.Flight;
import data.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BookingReader {
    public List<Booking> read() throws IOException {
        LinkedList<Booking> result = new LinkedList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/java/database/bookings.txt")))){
            String line;
            while((line = bufferedReader.readLine()) !=null){
                int number = 0;
                StringBuilder sb_id_booking = new StringBuilder();
                StringBuilder sb_name = new StringBuilder();
                StringBuilder sb_surname = new StringBuilder();
                StringBuilder sb_id = new StringBuilder();
                StringBuilder sb_city = new StringBuilder();
                StringBuilder sb_day = new StringBuilder();
                StringBuilder sb_month = new StringBuilder();
                StringBuilder sb_year = new StringBuilder();
                StringBuilder sb_hour = new StringBuilder();
                StringBuilder sb_min = new StringBuilder();
                StringBuilder sb_seats = new StringBuilder();
                for(char ch : line.toCharArray()){
                    if(ch != ',' && ch != ':' && ch != '/'){
                        if(number ==0){
                            sb_id_booking.append(ch);
                        }
                        if(number ==1){
                            sb_name.append(ch);
                        }
                        if(number ==2){
                            sb_surname.append(ch);
                        }
                        if(number ==3){
                            sb_id.append(ch);
                        }
                        if(number ==4){
                            sb_city.append(ch);
                        }
                        if(number ==5){
                            sb_day.append(ch);
                        }
                        if(number ==6){
                            sb_month.append(ch);
                        }
                        if(number ==7){
                            sb_year.append(ch);
                        }
                        if(number ==8){
                            sb_hour.append(ch);
                        }
                        if(number ==9){
                            sb_min.append(ch);
                        }
                        if(number ==10){
                            sb_seats.append(ch);
                        }
                    } else number++;
                }
                result.add(new Booking(new User(sb_name.toString(), sb_surname.toString()),
                        new Flight(Integer.parseInt(sb_id.toString()),
                                sb_city.toString(),
                                Integer.parseInt(sb_day.toString()),
                                Integer.parseInt(sb_month.toString()),
                                Integer.parseInt(sb_year.toString()),
                                Integer.parseInt(sb_hour.toString()),
                                Integer.parseInt(sb_min.toString()),
                                Integer.parseInt(sb_seats.toString())),
                        Integer.parseInt(sb_id_booking.toString())));
            }
        }
        return result;
    }
}
