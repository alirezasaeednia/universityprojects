import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class client4 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
    private static final String imei = "5566778899";

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(imei);

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

            scheduler.scheduleAtFixedRate(() -> sendHealthData(out), 0, 30, TimeUnit.SECONDS);
            scheduler.scheduleAtFixedRate(() -> sendLocationData(out), 0, 45, TimeUnit.SECONDS);

            String serverMessage;
            while ((serverMessage = in.readLine()) != null) {
                log("Server: " + serverMessage);
                if (serverMessage.contains("POWEROFF")) {
                    handlePowerOff();
                } else if (serverMessage.contains("FIND")) {
                    handleFind();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendHealthData(PrintWriter out) {
        Random random = new Random();
        int heartRate = 60 + random.nextInt(40);
        int bpLow = 60 + random.nextInt(40);
        int bpHigh = 100 + random.nextInt(40);
        String healthData = String.format("[3G*%s*HEALTH*%d,%d,%d]", imei, heartRate, bpLow, bpHigh);
        out.println(healthData);
        log("Sent: " + healthData);
    }

    private static void sendLocationData(PrintWriter out) {
        Random random = new Random();
        double lat = 37.7749 + random.nextDouble() * 0.01;
        double lon = -122.4194 + random.nextDouble() * 0.01;
        String locationData = String.format("[3G*%s*UD,%.4f,%.4f]", imei, lat, lon);
        out.println(locationData);
        log("Sent: " + locationData);
    }

    private static void handlePowerOff() {
        log("Handling power off command. Shutting down...");
        System.exit(0);
    }

    private static void handleFind() {
        log("Handling find command. Ringing for 30 seconds...");
        try {
            Thread.sleep(30000); // Simulating ringing for 30 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void log(String message) {
        System.out.println(message);
    }
}
