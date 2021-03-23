package com.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqliteTest {

    @Test
    public void connection() {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:C://SQLite/database/demo.db");
            Statement st = c.createStatement();
            String sql = "SELECT * from student";
            st.executeQuery(sql);

            st.close();
            c.close();

            System.out.println("Database opened successful!");
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
