package com.varhzj.lab.concurrency.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by varhzj on 11/2/16.
 * When a thread calls ThreadLocal.get for the first time,
 * initialValue is consulted to provide the initial val for that thread.
 */
public class ConnectionDispenser {

    private static String DB_URL = "jdbc:mysql://localhost:3306/test";

    private ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        @Override
        protected Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                throw new RuntimeException("Unable to acquire Connection", e);
            }
        }
    };

    public Connection getConnection() {
        return connectionHolder.get();
    }

}
