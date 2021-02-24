import java.net.*; 
import java.io.*; 
  public class Client1 
{  
       public static void main(String args[]) 
    { 
        try{
        Socket s = new Socket("127.0.0.1",5000);
       System.out.println("client correctly connects to Server  ");
      DataInputStream    in = new DataInputStream(s.getInputStream()); 
      DataOutputStream  out = new DataOutputStream(s.getOutputStream()); 
      BufferedReader br = new  BufferedReader (new InputStreamReader(System.in));
             String min = "",  mout="";
  
            // reads message from client until "bye" is sent 
            while (!min.equals("bye")) 
            {    mout=br.readLine();
                  out.writeUTF(mout);
                 min = in.readUTF(); 

                    min=br.readLine();
                    System.out.println(min); 
                 }
s.close();
}
catch(Exception e){
}
         }       } 