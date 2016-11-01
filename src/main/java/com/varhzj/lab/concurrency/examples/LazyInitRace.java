package com.varhzj.lab.concurrency.examples;

/**
 * Created by varhzj on 11/1/16.
 * 延迟初始化下的竞态条件
 */
public class LazyInitRace {

    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }
}

class ExpensiveObject {}