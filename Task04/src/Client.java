import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try{
            Socket s = new Socket("localhost", 7777);
            
            InputStreamReader input = new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader reader = new BufferedReader(input);
            
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);
            
            Scanner sc=new Scanner(System.in);
            while(true){
                String from_server=reader.readLine();
                System.out.println("From server : "+from_server);
                String user_output3=sc.nextLine();
                writer.println(user_output3);
                
                String from_server2=reader.readLine();
                System.out.println(from_server2);

                if(from_server2.equals("Give Numbers")){
                    String user_output=sc.nextLine();
                    writer.println(user_output);

                    String user_output2=sc.nextLine();
                    writer.println(user_output2);

                    String from_server3=reader.readLine();
                    System.out.println("From server : "+from_server3);
                    break;
                }
                    
                
            }  
            
            s.close();
            
        }catch(Exception e){System.out.println(e);}
    }
}