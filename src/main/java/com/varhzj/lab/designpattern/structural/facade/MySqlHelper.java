package com.varhzj.lab.designpattern.structural.facade;

import java.sql.Connection;

/**
 * Created by varhzj on 10/17/16.
 */
public class MySqlHelper {

    public static Connection getMySqlDBConnection() {
        return null;
    }

    public void generateMySqlPDFReport(String tableName, Connection conn) {
        // get data and generate pdf report
    }

    public void generateMySqlHTMLReport(String tableName, Connection conn) {
        // get data and generate html report
    }

}
