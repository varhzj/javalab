package com.varhzj.lab.designpattern.structural.proxy;

/**
 * Created by varhzj on 10/17/16.
 */
public class CommandExecutorImpl implements CommandExecutor {


    @Override
    public void runCommand(String cmd) throws Exception {
        Runtime.getRuntime().exec(cmd);
        System.out.println("Executed cmd: " + cmd);
    }
}
