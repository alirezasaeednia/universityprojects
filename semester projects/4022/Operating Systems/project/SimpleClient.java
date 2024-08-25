import java.io.*;
import java.net.*;

public class SimpleClient {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send a write command
            out.println("WRITE");
            out.println("example.txt");
            out.println("This is a test file content.");

            String response = in.readLine();
            System.out.println("Server response: " + response);

            // Send an append command
            out.println("APPEND");
            out.println("example.txt");
            out.println("This is appended content.");

            response = in.readLine();
            System.out.println("Server response: " + response);

            // Send a read command
            out.println("READ");
            out.println("example.txt");

            String line;
            while (!(line = in.readLine()).equals("END_OF_FILE")) {
                System.out.println("File content: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
