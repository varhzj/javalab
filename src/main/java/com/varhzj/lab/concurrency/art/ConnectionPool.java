package com.varhzj.lab.concurrency.art;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by varhzj on 11/24/16.
 */
public class ConnectionPool {

    private final LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize < 1) {
            throw new IllegalArgumentException("initialSize must > 0.");
        }
        for (int i = 0; i < initialSize; i++) {
            pool.addLast(ConnectionDriver.createConnection());
        }
    }

    public Connection getConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            }

            long future = System.currentTimeMillis() + mills;
            long remaining = mills;
            while (pool.isEmpty() && remaining > 0) {
                pool.wait(remaining);
                remaining = future - System.currentTimeMillis();
            }
            if (pool.isEmpty()) {
                return null;
            }
            return pool.removeFirst();
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

}
