package com.teben.service;

import com.teben.model.Student;
import com.teben.repository.H2JDBC;

import java.sql.*;

public class StudentService {
    private static Connection connection = H2JDBC.connectH2();
    private static Statement statement = null;

    public static void initializeStudentTable() throws SQLException {
        insertStudent(new Student(1,"Jacob", "Sallow", 18,
                "Obere Str. 57", "Berlin", "Germany"));
        insertStudent(new Student(2,"Noah", "Fernsby", 25,
                "Avda. de la Constitución 2222", "México D.F.", "Mexico"));
        insertStudent(new Student(3,"Ethan", "Villan", 30,
                "Mataderos 2312", "México D.F.", "Germany"));
        insertStudent(new Student(4,"Arthur", "Miracle", 28,
                "120 Hanover Sq.", "London", "UK"));
        insertStudent(new Student(5,"Joshua", "Dankworth", 19,
                "Berguvsvägen 8", "Luleå", "Sweden"));
    }

    public static void createStudentTable() throws SQLException {
        statement = connection.createStatement();
        String sql = "CREATE TABLE Students " +
                "(id INTEGER not NULL," +
                "firstName VARCHAR(255)," +
                "lastName VARCHAR(255)," +
                "age INTEGER," +
                "Address VARCHAR," +
                "City VARCHAR," +
                "Country VARCHAR," +
                "PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
        statement.close();
    }

    public static void insertStudent(Student student) throws SQLException{
        statement = connection.createStatement();
        String sql = "INSERT INTO Students " + "VALUES (" +
                student.getId() + ", '" +
                student.getFirstName() + "', '" +
                student.getLastName() + "', " +
                student.getAge() + ", '" +
                student.getAddress() + "', '" +
                student.getCity() + "', '" +
                student.getCountry() + "')";
        statement.executeUpdate(sql);
        statement.close();
    }

    public static void selectStudentTable(String sql) throws SQLException{
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

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
        statement.close();
    }

    public static void selectOrderedByColumn(String column) throws SQLException{
        String sql = "SELECT * FROM Students ORDER BY " + column;
        System.out.println("\nStudents ordered by " + column);
        selectStudentTable(sql);
    }

    public static void selectStudentsByAge(int lowAge, int highAge) throws SQLException {
        String sql = "SELECT * FROM Students WHERE age BETWEEN " + lowAge + " AND " + highAge;
        System.out.println("\nStudents aged " + lowAge + " to " + highAge);
        selectStudentTable(sql);
    }

    public static void selectStudentsByNameFirstLetter(char letter) throws SQLException{
        String sql = "SELECT * FROM Students WHERE firstName LIKE '" + letter +"%' ";
        System.out.println("\nStudents whose first name starts with " + letter);
        selectStudentTable(sql);
    }

    public static void selectCountOfStudents() throws SQLException {
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT COUNT (*) AS total FROM Students");
        System.out.print("\nTotal count of students: ");

        while (rs.next()) {
            int total = rs.getInt("total");
            System.out.println(total);
        }
        statement.close();
    }
}
