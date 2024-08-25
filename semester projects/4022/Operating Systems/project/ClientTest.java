import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ClientTest {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 12345;
    private static final int NUM_CLIENTS = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_CLIENTS);

        for (int i = 0; i < NUM_CLIENTS; i++) {
            executorService.execute(new ClientTask(i));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ClientTask implements Runnable {
        private int clientId;

        public ClientTask(int clientId) {
            this.clientId = clientId;
        }

        @Override
        public void run() {
            try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                // Write command
                String fileName = "testfile_" + clientId + ".txt";
                String fileContent = "Initial content from client " + clientId;
                out.println("WRITE");
                out.println(fileName);
                out.println(fileContent);

                String response = in.readLine();
                System.out.println("Client " + clientId + " write response: " + response);

                // Append command
                String appendContent = "Appended content from client " + clientId;
                out.println("APPEND");
                out.println(fileName);
                out.println(appendContent);

                response = in.readLine();
                System.out.println("Client " + clientId + " append response: " + response);

                // Read command
                out.println("READ");
                out.println(fileName);

                String line;
                System.out.println("Client " + clientId + " read response:");
                while (!(line = in.readLine()).equals("END_OF_FILE")) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
