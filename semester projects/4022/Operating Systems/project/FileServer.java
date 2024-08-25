import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class FileServer {
    private ServerSocket serverSocket;
    private static final int PORT = 12345;
    private static final int THREAD_POOL_SIZE = 10;
    private ExecutorService threadPool;
    private final Lock fileLock = new ReentrantLock();

    public FileServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        System.out.println("Server is listening on port " + port);
    }

    public void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");
                threadPool.execute(new ClientHandler(clientSocket, fileLock));
            } catch (IOException e) {
                System.out.println("Error accepting client connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try {
            FileServer server = new FileServer(PORT);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private final Lock fileLock;
    private static final String FILE_DIRECTORY = "./files";

    public ClientHandler(Socket socket, Lock fileLock) {
        this.clientSocket = socket;
        this.fileLock = fileLock;
    }

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.println("Handling client with thread ID: " + threadId);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String fileContent;
            String command;
            while ((command = in.readLine()) != null) {
                String fileName = in.readLine();
                System.out.println("Command: " + command + ", File: " + fileName);

                if (command.equalsIgnoreCase("READ")) {
                    readFile(out, fileName);
                } else if (command.equalsIgnoreCase("WRITE")) {
                    fileContent = in.readLine();
                    writeFile(fileName, fileContent);
                    out.println("Write successful");
                } else if (command.equalsIgnoreCase("APPEND")) {
                    fileContent = in.readLine();
                    appendToFile(fileName, fileContent);
                    out.println("Append successful");
                } else {
                    out.println("Invalid command");
                }
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing client socket: " + e.getMessage());
            }
        }
    }

    private void readFile(PrintWriter out, String fileName) {
        fileLock.lock();
        try {
            File file = new File(FILE_DIRECTORY, fileName);
            if (file.exists()) {
                try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = fileReader.readLine()) != null) {
                        out.println(line);
                    }
                    out.println("END_OF_FILE");
                } catch (IOException e) {
                    out.println("Error reading file: " + e.getMessage());
                }
            } else {
                out.println("File not found");
            }
        } finally {
            fileLock.unlock();
        }
    }

    private void writeFile(String fileName, String fileContent) {
        fileLock.lock();
        try {
            File file = new File(FILE_DIRECTORY, fileName);
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {
                fileWriter.write(fileContent);
            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }
        } finally {
            fileLock.unlock();
        }
    }

    private void appendToFile(String fileName, String fileContent) {
        fileLock.lock();
        try {
            File file = new File(FILE_DIRECTORY, fileName);
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {
                fileWriter.write(fileContent);
            } catch (IOException e) {
                System.out.println("Error appending to file: " + e.getMessage());
            }
        } finally {
            fileLock.unlock();
        }
    }
}
