// Omar Rodriguez
// CS 380
// Professor Nima Davarpanah

import java.io.*;
import java.net.*;
import java.util.*;

public final class EchoClient {

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 22222)) {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            Scanner keyboard = new Scanner (System.in);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Client> ");
            String in = keyboard.nextLine().toLowerCase();

            while(!in.equals("exit")) {
            	output.println(in);
            	System.out.println(br.readLine());
            	System.out.print("Client> ");
            	in = keyboard.nextLine();
            }

            socket.close();

        }
    }
}
