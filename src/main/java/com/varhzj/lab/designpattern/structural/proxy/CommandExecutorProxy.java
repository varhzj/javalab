package com.varhzj.lab.designpattern.structural.proxy;

/**
 * Created by varhzj on 10/17/16.
 */
public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor commandExecutor;

    public CommandExecutorProxy(String user, String pwd) {
        if ("root".equalsIgnoreCase(user) && "root".equalsIgnoreCase(pwd)) {
            isAdmin = true;
        }
        commandExecutor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
//        if (isAdmin) {
//            commandExecutor.runCommand(cmd);
//        }
//        else {
//            if (cmd.trim().startsWith("rm")) {
//                throw new Exception("cannot execute rm command for non-root user.");
//            }
//            commandExecutor.runCommand(cmd);
//        }
        if (!isAdmin && cmd.trim().startsWith("rm")) {
            throw new Exception("cannot execute rm command for non-root user.");
        }

        commandExecutor.runCommand(cmd);
    }
}
