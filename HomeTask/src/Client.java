import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 8789);

            InputStreamReader input = new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader reader = new BufferedReader(input);

            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);

            Scanner sc = new Scanner(System.in);

            String from_server = reader.readLine();
            System.out.println("From server: "+from_server);

            String c = sc.nextLine();
            writer.println(c);

            int x=0;
            while(x<c.length()) {
                String from_Server2 = reader.readLine();
                System.out.println(from_Server2);
                x++;
            }
            s.close();
            sc.close();
        }catch(Exception e) {System.out.println(e);}
    }
}