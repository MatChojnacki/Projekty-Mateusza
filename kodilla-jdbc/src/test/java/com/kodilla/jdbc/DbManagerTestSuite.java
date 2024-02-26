package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;
import java.sql.*;


import static org.junit.jupiter.api.Assertions.*;

class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }
    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }
    @Test
    void testSelectUsersAndPosts () throws SQLException {
         //Given
         DbManager dbManager= DbManager.getInstance();

         //When
        String sqlQuery = """
                SELECT users.FIRSTNAME, users.LASTNAME
                FROM users
                JOIN posts ON users.id = posts.user_id
                GROUP BY users.id
                HAVING COUNT(posts.id) >= 2 ;
                """;

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        // then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("LASTNAME")
                    + ", " + rs.getString("FIRSTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(3, counter);
    }
    }









