package executor;

import java.sql.*;

import static db.JDBC.*;
import static service.StudentService.*;

public class Executor {
    static Connection conn = null;
    static Statement stmt = null;

    public static void execute() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            Executor.createTable();
            inserts(stmt);
            selects(stmt);
            selectsByName(stmt);
            selectsOrderedByAge(stmt);
            delete(stmt);
            count(stmt);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("End of program");
    }

    public static void createTable() throws SQLException {
        System.out.println("Creating table in db... ");

        stmt = conn.createStatement();
        String sql = "CREATE TABLE Students " +
                "(id INTEGER not NULL," +
                "firstName VARCHAR(255)," +
                "lastName VARCHAR(255)," +
                "age INTEGER," +
                "Address VARCHAR," +
                "City VARCHAR," +
                "Country VARCHAR," +
                "PRIMARY KEY ( id ))";
        stmt.executeUpdate(sql);
        System.out.println("Created table Students");
    }
}
