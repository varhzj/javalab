package com.varhzj.lab.designpattern.behavioral.command;

/**
 * Created by varhzj on 10/19/16.
 */
public class FileInvoker {

    private Command command;

    public FileInvoker(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

}
