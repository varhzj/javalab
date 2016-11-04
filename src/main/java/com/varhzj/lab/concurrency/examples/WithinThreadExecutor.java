package com.varhzj.lab.concurrency.examples;

import java.util.concurrent.Executor;

/**
 * Created by varhzj on 11/4/16.
 * Executor that executes tasks synchronously in the calling thread
 */
public class WithinThreadExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
