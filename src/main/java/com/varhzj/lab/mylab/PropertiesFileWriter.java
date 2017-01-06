package com.varhzj.lab.mylab;

import java.io.*;
import java.util.Properties;

/**
 * Created by varhzj on 12/20/16.
 */
public class PropertiesFileWriter {

    public static void main(String[] args) throws IOException {
//        PropertiesFileWriter.class.getClass().getResourceAsStream("flume.conf");
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("/Users/varhzj/WorkSpace/Learn/javalab/src/main/resources/flume.conf"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
        BufferedReader reader = new BufferedReader(new FileReader("/Users/varhzj/WorkSpace/Learn/javalab/src/main/resources/test.txt"));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

}
