package com.varhzj.lab.concurrency.examples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by varhzj on 11/4/16.
 */
public class SingleThreadWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket socket = serverSocket.accept();
            handleRequest(socket);
        }
    }

    private static void handleRequest(Socket socket) {
        // request handler logic
    }

}
