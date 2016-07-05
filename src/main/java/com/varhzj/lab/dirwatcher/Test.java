package com.varhzj.lab.dirwatcher;

import java.io.File;

/**
 * Created by huangzhijian on 16-6-23.
 */
public class Test {

    String[] instanceDirs;

    public static void main(String[] args) {
        String dir = "/opt/logs/*./log";
        String regex = "*.";
        String[] splits = dir.split("/");
        String tailDirPrefix = "";
        for (String s : splits) {
            if (s.equals(regex))
                break;
            tailDirPrefix += s + "/";
        }
        System.out.println(tailDirPrefix);
        String[] tailDirs;
        String[] instanceDirs = new File(tailDirPrefix).list();
        for (String insDir : instanceDirs) {
            System.out.println(dir.replace(regex,insDir));
        }
    }

}
