import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8789);
            System.out.println("Server Initiated!");
            Socket s = ss.accept();
            System.out.println("Client Connected");

            InputStreamReader input = new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader reader = new BufferedReader(input);

            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);

            writer.println("hello world.");
            String line = reader.readLine();

            int x=0; 
            while(x<line.length()){
                int aschiMessage = line.charAt(i);
                writer.println(aschiMessage);
                x++;
            }
            ss.close();
        }catch(Exception e) {System.out.println(e);}
    }
}