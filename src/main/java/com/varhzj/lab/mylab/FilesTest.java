package com.varhzj.lab.mylab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by varhzj on 3/7/17.
 */
public class FilesTest {

    public static void main(String[] args) {
        File file = new File("/Users/varhzj/WorkSpace/Learn/javalab/src/main/resources/logback.bak");
        try {
            Object attribute = Files.getAttribute(file.toPath(), "unix:dev");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
