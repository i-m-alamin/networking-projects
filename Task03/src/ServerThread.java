import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread{
    Socket s;
    
    ServerThread(Socket s){
        this.s = s;
    }
    
    @Override
    public void run(){
        InputStream input= null;
        try {
            DataOutputStream output= new DataOutputStream(s.getOutputStream());
            PrintWriter writer=new PrintWriter(output,true);
            input = s.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(input));
            while(true){
                String from_client=reader.readLine();
                
                if(from_client.equalsIgnoreCase("end game")){
                    writer.println("Good Bye");
                    break;
                }
                else{
                    writer.println(from_client);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}