package com.varhzj.lab.designpattern.structural.facade;

import java.sql.Connection;

/**
 * Created by varhzj on 10/17/16.
 * Provide a unified interface for a set of interfaces in a subsystem.
 * Facade pattern defines a higher-level interface that make the subsystem easier to use.
 * Also hide details or some methods from client to use.
 * Actually, I don't think it's a good example to use here(^-^)!
 */
public class FacadeHelper {

    public static enum DBType {
        MYSQL, ORACLE;
    }

    public static enum ReportType {
        PDF, HTML;
    }

    public static void generateReport(DBType dbType, ReportType reportType, String tableName) {
        Connection conn = null;
        switch (dbType) {
            case MYSQL:
                conn = MySqlHelper.getMySqlDBConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();
                switch (reportType) {
                    case PDF:
                        mySqlHelper.generateMySqlPDFReport(tableName, conn);
                        break;
                    case HTML:
                        mySqlHelper.generateMySqlHTMLReport(tableName, conn);
                        break;
                }
                break;
            case ORACLE:
                conn = OracleHelper.getOracleDBConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType) {
                    case PDF:
                        oracleHelper.generateOraclePDFReport(tableName, conn);
                        break;
                    case HTML:
                        oracleHelper.generateOracleHTMLReport(tableName, conn);
                        break;
                }
                break;
        }
    }

}
