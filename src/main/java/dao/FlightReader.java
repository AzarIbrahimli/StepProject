package dao;
import data.Flight;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlightReader {
    public List<Flight> read() throws IOException {
        LinkedList<Flight> result = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/java/database/flights.txt")));
        String line;
        while((line = bufferedReader.readLine()) !=null){
            int number = 0;
            StringBuilder sb_id = new StringBuilder();
            StringBuilder sb_city = new StringBuilder();
            StringBuilder sb_day = new StringBuilder();
            StringBuilder sb_month = new StringBuilder();
            StringBuilder sb_year = new StringBuilder();
            StringBuilder sb_hour = new StringBuilder();
            StringBuilder sb_min = new StringBuilder();
            StringBuilder sb_seats = new StringBuilder();
            for(char a : line.toCharArray()){
                if(a != ',' && a != ':' && a != '/'){
                    if(number ==0){
                        sb_id.append(a);
                    }
                    if(number ==1){
                        sb_city.append(a);
                    }
                    if(number ==2){
                        sb_day.append(a);
                    }
                    if(number ==3){
                        sb_month.append(a);
                    }
                    if(number ==4){
                        sb_year.append(a);
                    }
                    if(number ==5){
                        sb_hour.append(a);
                    }
                    if(number ==6){
                        sb_min.append(a);
                    }
                    if(number ==7){
                        sb_seats.append(a);
                    }
                } else number++;
            }
            result.add(new Flight(Integer.parseInt(sb_id.toString()),
                    sb_city.toString(),
                    Integer.parseInt(sb_day.toString()),
                    Integer.parseInt(sb_month.toString()),
                    Integer.parseInt(sb_year.toString()),
                    Integer.parseInt(sb_hour.toString()),
                    Integer.parseInt(sb_min.toString()),
                    Integer.parseInt(sb_seats.toString())));
        }
        return new ArrayList<>(result);
    }
}
