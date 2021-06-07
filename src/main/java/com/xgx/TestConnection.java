package com.xgx;

import java.sql.*;
import java.util.Properties;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/11/5 15:05 <br/>
 */
public class TestConnection {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.facebook.presto.jdbc.PrestoDriver");
        //String url = "jdbc:presto://192.168.137.103:8080/mongodb/testpresto";
        String url = "jdbc:presto://192.168.137.103:8080/mongodb/20171107chinadaas";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        Connection connection = DriverManager.getConnection(url,properties);
        Statement stmt = connection.createStatement();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("show tables");
            //rs = stmt.executeQuery("select * from upcase limit 1");
            while (rs.next()) {
               // System.out.println(rs.getString(1) + "--" + rs.getString(2));
                System.out.println(rs.getString(1));
            }
            rs.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            if(rs != null)
                rs.close();
            connection.close();
        }
    }
}
