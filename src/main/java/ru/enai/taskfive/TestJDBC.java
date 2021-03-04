package ru.enai.taskfive;

import java.sql.*;

public class TestJDBC {
    private static final String USER = "postgres";
    private static final String PASSWORD = "auk6";
    private static final String URL = "jdbc:postgresql://localhost:5432/test";


    public static void main(String[] args) {
        System.out.println(getResultSqlQuery("SELECT count(distinct(id)) FROM users"));
    }

    public static String getResultSqlQuery(String query) {
        String resultQuery = "Count Id: ";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                resultQuery += result.getString(1);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultQuery;
    }

}
