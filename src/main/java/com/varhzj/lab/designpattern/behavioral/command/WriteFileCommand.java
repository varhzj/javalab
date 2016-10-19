package com.varhzj.lab.designpattern.behavioral.command;

/**
 * Created by varhzj on 10/19/16.
 */
public class WriteFileCommand implements Command {

    private FileSystemReceiver receiver;

    public WriteFileCommand(FileSystemReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.writeFile();
    }
}
