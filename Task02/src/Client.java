import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try{
            Socket s=new Socket("localhost",7777);
            
            InputStream input= s.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(input));
            
            DataOutputStream output= new DataOutputStream(s.getOutputStream());
            PrintWriter writer=new PrintWriter(output,true);
            
            Scanner sc=new Scanner(System.in);
            
            while(true){
                System.out.println("HeLlOOOO, HOW ARE YOU SERVER = ");
                String user_output=sc.nextLine();
                writer.println(user_output);
                
                String from_server=reader.readLine();
                    
                    if(from_server.equalsIgnoreCase("Good Bye")){
                        break;
                    }
                    else{
                        System.out.println("From server = "+from_server);
                    }
            }
            
            
            
            
            s.close();
            
        }catch(Exception e){System.out.println(e);}
    }
}