package com.varhzj.lab.designpattern.structural.facade;

import java.sql.Connection;

/**
 * Created by varhzj on 10/17/16.
 */
public class OracleHelper {

    public static Connection getOracleDBConnection() {
        return null;
    }

    public void generateOraclePDFReport(String tableName, Connection conn) {
        // get data and generate pdf report
    }

    public void generateOracleHTMLReport(String tableName, Connection conn) {
        // get data and generate html report
    }

}
