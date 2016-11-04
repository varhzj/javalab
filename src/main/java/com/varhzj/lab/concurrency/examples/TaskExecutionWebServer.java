package com.varhzj.lab.concurrency.examples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by varhzj on 11/4/16.
 */
public class TaskExecutionWebServer {

    private static final int THREAD_NUM = 100;
    private static final Executor exec = Executors.newFixedThreadPool(THREAD_NUM);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket socket = serverSocket.accept();
            exec.execute(() -> handleRequest(socket)); // lambda
        }
    }

    private static void handleRequest(Socket socket) {
        // logic here
    }

}
