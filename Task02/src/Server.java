import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args) {
        try {
            while(true) {
                ServerSocket ss = new ServerSocket(7777);
                System.out.println("Server Running at port : 7777");
                Socket socket = ss.accept();
                System.out.println("client connected");
                
                InputStreamReader input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
                BufferedReader reader = new BufferedReader(input);
                
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(output, true);
            
                while(true) {
                    String clinet_Response = reader.readLine();
                    
                    if(clinet_Response.equalsIgnoreCase("end game")) {
                        writer.println("good bye");
                        break;
                    }
                    else {
                        writer.println(clinet_Response);    
                    }
                }
                ss.close();
            }
        }catch(Exception e) {System.out.println(e);}
    }
}