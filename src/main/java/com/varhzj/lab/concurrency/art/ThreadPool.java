package com.varhzj.lab.concurrency.art;

/**
 * Created by varhzj on 11/24/16.
 */
public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutDown();

    void addWorkers(int num);

    void removeWorkers(int num);

    int getJobSize();

}
