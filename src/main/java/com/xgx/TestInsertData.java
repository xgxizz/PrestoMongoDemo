package com.xgx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/11/10 12:42 <br/>
 */
public class TestInsertData {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String tableSql = "insert into basic(entid, entname) values ('11111', 'test')";
//        String tableSql = "drop table interface_info";

        Class.forName("com.facebook.presto.jdbc.PrestoDriver");
        String url = "jdbc:presto://192.168.137.103:8080/mongodb/testpresto";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        Connection connection = DriverManager.getConnection(url,properties);
        Statement stmt = connection.createStatement();
        try {
            stmt.executeUpdate(tableSql);
            stmt.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            connection.close();
        }
    }
}
