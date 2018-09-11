package com.varhzj.lab.utils;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class InetUtil {

    /**
     * 获取本机ip
     * @return ip
     */
    public static String localIp() {
        try(DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            return socket.getLocalAddress().getHostAddress();
        } catch (SocketException | UnknownHostException e) {
            return "127.0.0.1";
        }
    }

    public static void main(String[] args) {
        System.out.println(localIp());
    }

}
