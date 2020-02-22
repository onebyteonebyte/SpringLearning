package com.itheima.jdbc;

import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy","root","root");
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        rs.close();
        pstm.close();
        conn.close();
    }
}
