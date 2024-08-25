import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Scanner;

public class SmartwatchServer {

    private static final int PORT = 12345;
    private static final String LOG_FILE = "server_log.txt";
    private static final Map<String, ClientHandler> clients = new ConcurrentHashMap<>();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        executorService.execute(SmartwatchServer::listenForCommands);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            log("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            log("Error starting server: " + e.getMessage());
        }
    }

    private static void listenForCommands() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (FORMAT: IMEI COMMAND): ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                String imei = parts[0];
                String command = parts[1].toUpperCase();
                sendCommandToClient(imei, command);
            } else {
                System.out.println("Invalid command format. Use: IMEI COMMAND");
            }
        }
    }

    public static void sendCommandToClient(String imei, String command) {
        ClientHandler clientHandler = clients.get(imei);
        if (clientHandler != null) {
            clientHandler.sendCommand(command);
            log("Sent command to IMEI " + imei + ": " + command);
        } else {
            log("No client with IMEI " + imei + " connected.");
        }
    }

    private static void log(String message) {
        synchronized (SmartwatchServer.class) {
            try (FileWriter fw = new FileWriter(LOG_FILE, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                out.println(timeStamp + " - " + message);
            } catch (IOException e) {
                System.err.println("Error writing to log file: " + e.getMessage());
            }
        }
    }

    private static void logHealthMessage(String mes,String message) {
        try {
            String messag = message.substring(1,message.length()-1);
            String[] parts = messag.split("\\*");
            String[] healthData = parts[3].split(",");

            int heartrate = Integer.parseInt(healthData[0]);
            int bloodPressureLow = Integer.parseInt(healthData[1]);
            int bloodPressureHigh = Integer.parseInt(healthData[2]);

            log(mes + String.format("heartrate = %d, blood pressure low = %s, blood pressure high = %s",
                    heartrate, bloodPressureLow, bloodPressureHigh));
        } catch (Exception e) {
            log("Failed to parse health message: " + e.getMessage());
        }
    }

    private static void logUDMessage(String mes,String message) {
        try {
            String messag = message.substring(1,message.length()-1);
            String[] parts = messag.split("\\*");
            String[] locationData = parts[2].split(",");

            double latitude = Double.parseDouble(locationData[1]);
            double longitude = Double.parseDouble(locationData[2]);

            log(mes + String.format("latitude = %.6f, longitude = %.6f", latitude, longitude));
        } catch (Exception e) {
            log("Failed to parse UD message: " + message);
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private String imei;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                this.out = new PrintWriter(clientSocket.getOutputStream(), true);

                this.imei = in.readLine();
                log("Client connected with IMEI: " + imei);
                clients.put(imei, this);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.contains("*HEALTH*")) {
                        logHealthMessage("Received from IMEI " + imei + ": " , inputLine);
                    } else if (inputLine.contains("*UD")) {
                        logUDMessage("Received from IMEI " + imei + ": ", inputLine);
                    } else {
                        log("Unknown message format: " + inputLine);
                    }
                }
            } catch (IOException e) {
                log("Error handling client with IMEI " + imei + ": " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                    clients.remove(imei);
                    log("Client with IMEI " + imei + " disconnected.");
                } catch (IOException e) {
                    log("Error closing client socket for IMEI " + imei + ": " + e.getMessage());
                }
            }
        }

        public void sendCommand(String command) {
            if (out != null) {
                out.println(command);
            }
        }
    }
}