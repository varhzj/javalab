package com.varhzj.lab.designpattern.behavioral.command;

/**
 * Created by varhzj on 10/19/16.
 */
public class OpenFileCommand implements Command {

    private FileSystemReceiver receiver;

    public OpenFileCommand(FileSystemReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.openFile();
    }
}
