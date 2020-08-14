package service;

import java.sql.*;

public class StudentService {
    public static void inserts(Statement stmt) throws SQLException{
        String sql = "INSERT INTO Students " + "VALUES (1, 'Jacob', 'Sallow', 18, " +
                "'Obere Str. 57', 'Berlin', 'Germany')";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO Students " + "VALUES (2, 'Noah', 'Fernsby', 25, " +
                "'Avda. de la Constitución 2222', 'México D.F.', 'Mexico')";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO Students " + "VALUES (3, 'Ethan', 'Villan', 30, " +
                "'Mataderos 2312', 'México D.F.', 'Mexico')";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO Students " + "VALUES(4, 'Noah', 'Miracle', 28, " +
                "'120 Hanover Sq.', 'London', 'UK')";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO Students " + "VALUES(5, 'Joshua', 'Dankworth', 19, " +
                "'Berguvsvägen 8', 'Luleå', 'Sweden')";
        stmt.executeUpdate(sql);

        System.out.println("Inserted students into the table...");
    }

    public static void selects(Statement stmt) throws SQLException{
        String sql = "SELECT * FROM Students";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            int id = rs.getInt("ID");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            int age = rs.getInt("age");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String country = rs.getString("Country");

            System.out.print("ID: " + id);
            System.out.print(", FirstName: " + firstName);
            System.out.print(", LastName: " + lastName);
            System.out.print(", Age: " + age);
            System.out.print(", Address: " + address);
            System.out.print(", City: " + city);
            System.out.println(", Country: " + country);
        }
    }

    public static void selectsOrderedByAge(Statement stmt) throws SQLException{
        String sql = "SELECT * FROM Students ORDER BY age ";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Students ordered by age");

        while(rs.next()) {
            int id = rs.getInt("ID");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            int age = rs.getInt("age");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String country = rs.getString("Country");

            System.out.print("ID: " + id);
            System.out.print(", FirstName: " + firstName);
            System.out.print(", LastName: " + lastName);
            System.out.print(", Age: " + age);
            System.out.print(", Address: " + address);
            System.out.print(", City: " + city);
            System.out.println(", Country: " + country);
        }
    }

    public static void delete(Statement stmt) throws SQLException {
        String sql = "SELECT * FROM Students WHERE age BETWEEN 20 AND 45 ";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Students ordered by age between 20 and 45");

        while(rs.next()) {
            int id = rs.getInt("ID");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            int age = rs.getInt("age");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String country = rs.getString("Country");

            System.out.print("ID: " + id);
            System.out.print(", FirstName: " + firstName);
            System.out.print(", LastName: " + lastName);
            System.out.print(", Age: " + age);
            System.out.print(", Address: " + address);
            System.out.print(", City: " + city);
            System.out.println(", Country: " + country);
        }
    }

    public static void selectsByName(Statement stmt) throws SQLException{
        String sql = "SELECT * FROM Students WHERE firstName LIKE 'J%' ";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Students whose first name starts with J");

        while(rs.next()) {
            int id = rs.getInt("ID");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            int age = rs.getInt("age");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String country = rs.getString("Country");

            System.out.print("ID: " + id);
            System.out.print(", FirstName: " + firstName);
            System.out.print(", LastName: " + lastName);
            System.out.print(", Age: " + age);
            System.out.print(", Address: " + address);
            System.out.print(", City: " + city);
            System.out.println(", Country: " + country);
        }
    }

    public static void count(Statement stmt) throws SQLException {
        String sql = "SELECT COUNT (*) AS total FROM Students";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Count of students");

        while (rs.next()) {
            int total = rs.getInt("total");
            System.out.println(total);
        }
    }
}
