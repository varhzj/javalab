package com.varhzj.lab.concurrency.examples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by varhzj on 16-11-4.
 */
public class LifecycleWebServer {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void stop() {
        executor.shutdown();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (!executor.isShutdown()) {
            try {
                Socket socket = serverSocket.accept();
                executor.submit(() -> handleRequest(socket));
            } catch (RejectedExecutionException e) {
                if (!executor.isShutdown()) {
                    log("task submission rejected", e);
                }
            }
        }
    }

    private void log(String msg, Exception e) {
        Logger.getAnonymousLogger().log(Level.WARNING, msg, e);
    }

    private void handleRequest(Socket socket) {
        Request request = readRequest(socket);
        if (isShutdownRequest(request)) {
            stop();
        } else {
            dispatchRequest(request);
        }
    }

    private void dispatchRequest(Request request) {

    }

    private boolean isShutdownRequest(Request request) {
        return false;
    }

    private Request readRequest(Socket socket) {
        return null;
    }


    interface Request {}
}
