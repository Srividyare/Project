srividya
 
 
More
 
1 of 1,173
 
(no subject)
Inbox
	x
Siddartha Guthikonda
	
10:31 PM (0 minutes ago)
		
to me
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client
{
  public static void main(String [] args)
  {
    String serverName = args[0];
    Socket client = null;
    // int port = Integer.parseInt(args[0]);
    try
    {


      Scanner s = new Scanner(System.in);
      while(true) {
        System.out.println("Please enter 'Fortune Cookie' for Fortune Cookie Server or enter 'encrypt' or 'decrypt' EncryptDcrypt Server");
        String input = s.nextLine();

        if (input.equalsIgnoreCase("Fortune Cookie")) {
          System.out.println("Connecting to " + serverName
              + " on port " + 9998);
          client = new Socket(serverName, 9998);
          System.out.println("Just connected to "
              + client.getRemoteSocketAddress());
          OutputStream outToServer = client.getOutputStream();
          DataOutputStream out =
              new DataOutputStream(outToServer);
          InputStream inFromServer = client.getInputStream();
          DataInputStream in =
              new DataInputStream(inFromServer);
          System.out.println("Please enter the number of cookie you want");
          String inputToServer = s.nextLine();



          out.writeUTF(inputToServer);

          System.out.println(":" + in.readUTF());
        }
        if (input.equalsIgnoreCase("encrypt") || input.equalsIgnoreCase("decrypt")) {
          System.out.println("Connecting to " + serverName
              + " on port " + 9997);
          client = new Socket(serverName, 9997);
          System.out.println("Just connected to "
              + client.getRemoteSocketAddress());
          OutputStream outToServer = client.getOutputStream();
          DataOutputStream out =
              new DataOutputStream(outToServer);
          InputStream inFromServer = client.getInputStream();
          DataInputStream in =
              new DataInputStream(inFromServer);
          String inputToServer = s.nextLine();
          out.writeUTF(inputToServer);
          System.out.println(":" + in.readUTF());
        } 
        if (input.equalsIgnoreCase("close")) {
          if (client != null) {
            client.close();
          }
        }
      } 

      //client.close();
    }catch(IOException e)
    {
      e.printStackTrace();
    }
  }
}
