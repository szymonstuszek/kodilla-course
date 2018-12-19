package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {

    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + ", "
            + resultSet.getString("FIRSTNAME") + ", "
            + resultSet.getString("LASTNAME"));
            counter++;
        }
        resultSet.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_COUNT " +
                "FROM POSTS P, USERS U " +
                "WHERE U.ID = P.USER_ID " +
                "GROUP BY U.ID " +
                "HAVING COUNT(*) > 2;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;

        while (resultSet.next()) {
            System.out.println(resultSet.getString("FIRSTNAME") + ", "
                    + resultSet.getString("LASTNAME"));
            counter++;
        }
        resultSet.close();
        statement.close();
        Assert.assertEquals(1, counter);
    }
}
