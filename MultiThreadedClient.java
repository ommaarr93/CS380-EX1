// Omar Rodriguez
// CS 380
// Professor Nima Davarpanah

import java.io.*;
import java.net.*;

public class MultiThreadedClient implements Runnable {

  Socket socket;

  public MultiThreadedClient(Socket socket) {
    super();
    this.socket = socket;
  }

  public void run() {

        try {
          String address = socket.getInetAddress().getHostAddress();
          System.out.print("Client connected: " + address);
          OutputStream os = socket.getOutputStream();
          PrintStream out = new PrintStream(os, true, "UTF-8");

          InputStream is = socket.getInputStream();
          InputStreamReader isr = new InputStreamReader(is, "UTF-8");
          BufferedReader br = new BufferedReader(isr);

          String in = "";

          while (in != null) {
            in = br.readLine();
            out.println("Server> " + in);
          }

          System.out.print("Client disconnected: " + address);
        }

        catch(IOException e) {
          //catch exception
        }
  }
}
