import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        try{
            while(true){
                ServerSocket ss=new ServerSocket(6666);
                System.out.println("Server Initiated");
                Socket s=ss.accept();
                System.out.println("Client Connected");

                new ServerThread(s).start();
                ss.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}