package com.varhzj.lab.interview.strings;

import com.sun.javafx.fxml.builder.URLBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Solution {


    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] ss = new String[]{
//                "abcdcba",
//                "",
//                "abcddcba",
//                "abadda"
//        };
//        for (String s : ss) {
//            System.out.println("String: {" + s + "} is palindrome? " + isPalindrome(s));
//        }
        try {
            System.setProperty("https.protocols","TLSv1.1,TLSv1.2");
            URL url = new URL("https://www.google.com/?gfe_rd=cr&dcr=0&ei=9QrOWeLhGdPRXqWFhPAK&gws_rd=cr&fg=1");
            SocketAddress proxyAddress = new InetSocketAddress("localhost", 1080);
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);
            URLConnection connection = url.openConnection(proxy);
            connection.setConnectTimeout(3000);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) >= 0) {
                System.out.println(new String(bytes));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
