import java.net.*; 
import java.io.*; 
  public class Server1 
{  
       public static void main(String args[]) 
    {  
        try{
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server works started");
       System.out.println("Waiting for the Client....");
         Socket s=  ss.accept();
       System.out.println("client connected ");
      DataInputStream    in = new DataInputStream(s.getInputStream()); 
      DataOutputStream  out = new DataOutputStream(s.getOutputStream()); 
       BufferedReader br = new  BufferedReader (new InputStreamReader(System.in));
             String min = "",mout="";
  
            // reads message from client until "bye" is sent 
            while (!min.equals("bye")) 
            { 
                   min = in.readUTF(); 
                    while((min=br.readLine())!=null){
                    System.out.println(min); 
                     mout=br.readLine();
                     out.writeUTF(mout);
                     out.flush();
                    }}
s.close();
}
catch(Exception e){
                } 
}
}