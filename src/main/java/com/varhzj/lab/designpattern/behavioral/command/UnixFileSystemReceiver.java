package com.varhzj.lab.designpattern.behavioral.command;

/**
 * Created by varhzj on 10/19/16.
 */
public class UnixFileSystemReceiver implements FileSystemReceiver {

    @Override
    public void openFile() {
        System.out.println("Open file in unix OS.");
    }

    @Override
    public void writeFile() {
        System.out.println("Write file in unix OS.");
    }

    @Override
    public void closeFile() {
        System.out.println("Close file in unix OS.");
    }
}
