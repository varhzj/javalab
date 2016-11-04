package com.varhzj.lab.concurrency.examples;

import java.util.concurrent.Executor;

/**
 * Created by varhzj on 11/4/16.
 */
public class ThreadPerTaskExecutor implements Executor {

    @Override
    public void execute(Runnable task) {
        new Thread(task).start();
    }

}
