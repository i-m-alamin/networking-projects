import java.net.*;
import java.io.*;
import java.util.Date;

public class Server {
    public static void main (String []args) {
        try {
            while (true) {
                ServerSocket ss = new ServerSocket(7777) ;
                System.out.println("Server Running at port : 7777");
                Socket socket = ss.accept();
                System.out.println("client connected");

                String today = new Date().toString();

                DataOutputStream output= new DataOutputStream(socket.getOutputStream());
                PrintWriter writer= new PrintWriter(output, true);

                writer.println(today);

                ss.close();
            }
        }
        catch(Exception e){System.out.println(e);}
    }

}