package com.varhzj.lab.mylab;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Created by varhzj on 11/10/16.
 */
public class URLConnDemo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.baidu.com");
        URLConnection urlConn = url.openConnection();
        System.out.println("Date: " + new Date(urlConn.getDate()));
        System.out.println("Content-Type: " + urlConn.getContentType());
        System.out.println("Expires: " + new Date(urlConn.getExpiration()));
        System.out.println("Content-Encode: " + urlConn.getContentEncoding());
    }

}

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {

    BoardGame(int i) {
        // 必需
        super(i);
        System.out.println("BoardGame constructor");
    }
}