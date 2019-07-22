package com.learn.mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C3P0Example {

    //C3P0不使用配置文件链接数据库
    @Test
    public void demo1() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1. 创建datasource
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            //2. 设置连接数据的信息
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost/test");
            dataSource.setUser("root");
            dataSource.setPassword("mysql");

            //2. 得到连接对象
            conn = dataSource.getConnection();
            String sql = "insert into hah values(7 , ? )";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "c3p0");
            int i = ps.executeUpdate();
            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //使用c3p0-config.xml配置
    @Test
    public void demo2() {
        try {
            //默认会找 xml 中的 c3p0-config 分支。
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            //2. 得到连接对象
            Connection conn = dataSource.getConnection();
            String sql = "insert into hah values(9 , ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "test");
            int i = ps.executeUpdate();
            System.out.println(i);
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
