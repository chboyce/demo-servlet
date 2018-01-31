package com.boyce.demo.servlet.dao;

import java.sql.*;

/**
 * Created by 姜青林 on 2018/1/30 16:17
 */
public class SqlDemo {

    static {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String url = "jdbc:mysql://172.16.10.71:3306/irs_crm_card01";
            String username = "irs_crm_rw";
            String password = "kjkoh85UGJG36";
            //2.获得数据库链接
            Connection conn = DriverManager.getConnection(url, username, password);
            //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from member limit 0,10");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " "
                        + rs.getString("mobile"));
            }
            //关闭资源
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
