package com.varhzj.lab.designpattern.behavioral.command;

/**
 * Created by varhzj on 10/19/16.
 */
public class FileSystemReceiveUtil {

    public static FileSystemReceiver getUnderlyingFileSystem() {
        String osName = System.getProperty("os.name");
        System.out.println("Underlying system OS is " + osName);
        if (osName.contains("Windows")) {
            return new WindowsFileSystemReceiver();
        }
        else {
            return new UnixFileSystemReceiver();
        }
    }

}
