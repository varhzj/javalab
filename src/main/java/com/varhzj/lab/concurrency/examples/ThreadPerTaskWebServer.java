package com.varhzj.lab.concurrency.examples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by varhzj on 11/4/16.
 */
public class ThreadPerTaskWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> handleRequest(socket)).start(); // lambda
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    handleRequest(socket);
//                }
//            };
//            new Thread(runnable).start();
        }
    }

    private static void handleRequest(Socket socket) {
        // logic here
    }

}
