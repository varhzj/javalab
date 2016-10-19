package com.varhzj.lab.designpattern.behavioral.command;

/**
 * Created by varhzj on 10/19/16.
 */
public class FileSystemClient {

    public static void main(String[] args) {
        FileSystemReceiver fsr = FileSystemReceiveUtil.getUnderlyingFileSystem();
        OpenFileCommand openFileCommand = new OpenFileCommand(fsr);
        FileInvoker fileInvoker = new FileInvoker(openFileCommand);
        fileInvoker.execute();

        WriteFileCommand writeFileCommand = new WriteFileCommand(fsr);
        fileInvoker = new FileInvoker(writeFileCommand);
        fileInvoker.execute();

        CloseFileCommand closeFileCommand = new CloseFileCommand(fsr);
        fileInvoker = new FileInvoker(closeFileCommand);
        fileInvoker.execute();
    }

}
