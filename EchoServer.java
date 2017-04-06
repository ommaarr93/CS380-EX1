// Omar Rodriguez
// CS 380
// Professor Nima Davarpanah

import java.io.*;
import java.net.*;

public final class EchoServer {

  public static void main(String[] args) throws Exception {

    try (ServerSocket serverSocket = new ServerSocket(22222)) {
      while (true) {

        try  {
          Thread thread= new Thread(new MultiThreadedClient(serverSocket.accept()));
          thread.start();
        }

        catch(IOException e) {
          // catch exception
        }
      }
    }
  }
}
