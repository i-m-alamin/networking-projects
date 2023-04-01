import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        try{
            
            ServerSocket ss = new ServerSocket(7777);
                System.out.println("Server Initiated.");
                Socket socket = ss.accept();
                System.out.println("Client accepted.");
                InputStreamReader input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
                BufferedReader reader = new BufferedReader(input);
                
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(output, true);

            while(true){
                writer.println("Press 1 for Add, Press 2 for Subtract,Press 3 for Multiply");
                String action=reader.readLine();
                int num=Integer.parseInt(action);
                if(num>3 || num<1){
                    writer.println("invalid number! try again");
                    
                }else{
                    writer.println("Give Numbers");
                    String p=reader.readLine();
                    String q=reader.readLine();
                    int answer=0;
                    if(action.equals("1")){
                        answer=Integer.parseInt(p)+Integer.parseInt(q);
                        writer.println("Answer = "+answer);
                        break;
                    }
                   
                else if(action.equals("2")){
                        if(Integer.parseInt(p)>Integer.parseInt(q)){
                            answer=Integer.parseInt(p)-Integer.parseInt(q);
                            writer.println("Answer = "+answer);
                        }else{
                            answer=Integer.parseInt(q)-Integer.parseInt(p);
                            writer.println("Answer = "+answer);
                        }
                        break;
                    }
                    else{
                        answer=Integer.parseInt(p)*Integer.parseInt(q);
                        writer.println("Answer = "+answer);
                        break;
                    }
                }
            }
            ss.close();
            
            
            
            
        }catch(Exception e){System.out.println(e);}
    }
}