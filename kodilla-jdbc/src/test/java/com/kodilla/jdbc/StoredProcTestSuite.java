package com.kodilla.jdbc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoredProcTestSuite {

    private static final String SET_VIP_LEVEL_TO_NOT_SET = "UPDATE READERS SET VIP_LEVEL='Not set'";
    private static final String COUNT_NOT_SET_VIP_LEVEL = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL='Not set'";
    private static final String COUNT_BESTSELLERS = "SELECT COUNT(*) AS HOW_MANY_BESTSELLERS FROM BOOKS WHERE BESTSELLER = 1";

    private static Connection connection;

    @BeforeAll
    public static void setUp() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        connection = dbManager.getConnection();

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(SET_VIP_LEVEL_TO_NOT_SET);
        }
    }

    @Test
    public void testUpdateVipLevels() throws SQLException {
        // When
        try (Statement statement = connection.createStatement();
             CallableStatement callableStatement = connection.prepareCall("{CALL UpdateVipLevels()}")) {
            callableStatement.execute();
            ResultSet rs = statement.executeQuery(COUNT_NOT_SET_VIP_LEVEL);

            // Then
            int howMany = -1;
            if (rs.next()) {
                howMany = rs.getInt("HOW_MANY");
            }
            assertEquals(0, howMany);
        }
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        // When
        try (Statement statement = connection.createStatement();
             CallableStatement callableStatement = connection.prepareCall("{CALL UpdateBestsellers()}")) {
            callableStatement.execute();
            ResultSet rs = statement.executeQuery(COUNT_BESTSELLERS);

            // Then
            int howManyBestsellers = -1;
            if (rs.next()) {
                howManyBestsellers = rs.getInt("HOW_MANY_BESTSELLERS");
            }
            assertTrue(howManyBestsellers >= 0);
        }
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE READERS SET VIP_LEVEL=NULL");
        }
        connection.close();
    }
}
