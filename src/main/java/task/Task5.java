package task;

import java.net.InetSocketAddress;
import java.net.Socket;

public class Task5 implements Task {
    private final String host;
    private final int startPort;
    private final int endPort;
    private volatile boolean running = false;
    private Thread workerThread;

    public static void solve() throws InterruptedException {
        var scanner = new Task5("localhost", 1000, 10000);
        new Thread(scanner::start).start();
        Thread.sleep(2000);
        scanner.stop();
        System.out.println("Сканирование прервано методом stop()");
    }

    public Task5(String host, int startPort, int endPort) {
        this.host = host;
        this.startPort = startPort;
        this.endPort = endPort;
    }

    @Override
    public void start() {
        if (running) return;
        running = true;
        workerThread = new Thread(() -> {
            System.out.printf("Сканирование %s начато%n", host);
            for (var port = startPort; port <= endPort && running; port++) {
                if (isPortOpen(host, port)) {
                    System.out.printf("Порт %d открыт%n", port);
                }
            }
            System.out.println("Сканирование завершено");
            running = false;
        });
        workerThread.start();
    }

    @Override
    public void stop() {
        running = false;
        if (workerThread != null) {
            workerThread.interrupt();
        }
    }

    private boolean isPortOpen(String host, int port) {
        try (var socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 200);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

interface Task
{
    void start();

    void stop();
}