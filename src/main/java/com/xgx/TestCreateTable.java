package com.xgx;

import java.sql.*;
import java.util.Properties;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/11/10 11:11 <br/>
 */
public class TestCreateTable {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String tableSql = "create table interface_info (" +
                "api_id int,"
                +"api_method varchar,"
                +"api_path varchar,"
                +"api_status int,"
                +"api_comment varchar,"
                +"api_type varchar,"
                +"api_script varchar,"
                +"api_schema varchar,"
                +"api_sample varchar,"
                +"api_create_time varchar,"
                + "api_gmt_time varchar) ";
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
