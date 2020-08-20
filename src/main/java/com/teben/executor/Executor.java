package com.teben.executor;

import com.teben.service.StudentService;

import java.sql.*;


public class Executor {
    private static StudentService studentService;

    public static void execute() {
        try {
            StudentService.createStudentTable();
            StudentService.initializeStudentTable();
            System.out.println("Students table");
            StudentService.selectStudentTable("SELECT * FROM Students");
            StudentService.selectsOrderedByColumn("age");
            StudentService.selectCountOfStudents();
            StudentService.selectStudentsByNameFirstLetter('J');
            StudentService.selectStudentsByAge(20, 45);

        } catch (SQLException se) {
            se.printStackTrace();
        }
        System.out.println("End of program");
    }
}
