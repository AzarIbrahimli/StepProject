package all;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    public static List<String> usernames = new ArrayList<>();
    public static void login() throws IOException {

        Scanner sc = new Scanner(System.in);
        Start start = new Start();
        System.out.print("Please, enter your username: ");
        String username = sc.nextLine();
        usernames.add(username);
        start.start();
    }
}