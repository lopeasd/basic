package com.learn.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DruidExample {

    //不使用配置文件
    @Test
    public void demo1() {

        try {
            DruidDataSource dd = new DruidDataSource();
            dd.setDriverClassName("com.mysql.jdbc.Driver");
            dd.setUrl("jdbc:mysql://localhost/test");
            dd.setUsername("root");
            dd.setPassword("mysql");
            Connection conn = dd.getConnection("root", "mysql");
            String sql = "insert into hah values(11, ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "druid");
            int i = ps.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //使用配置文件
    @Test
    public void demo2() {
        try {
            Properties pro = new Properties();
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //4.获取连接池对象
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            //5.获取连接
            Connection conn = ds.getConnection();

            String sql = "insert into hah values(10 , ? )";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "druid");
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
