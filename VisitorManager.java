package com.vms;

import java.sql.*;
import java.util.Scanner;

public class VisitorManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/visitor_management";
        String user = "root"; // change if your username is different
        String password = "Vishnu@178"; // put your MySQL password here

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Visitor Name:");
        String visitor_name = sc.nextLine();

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        System.out.println("Enter Contact Number:");
        String contact_number = sc.nextLine();

        System.out.println("Whom to Visit:");
        String whom_to_visit = sc.nextLine();

        System.out.println("Enter Visit Date (yyyy-mm-dd):");
        String visit_date = sc.nextLine();

        System.out.println("Enter Visit Time (hh:mm:ss):");
        String visit_time = sc.nextLine();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO visitors (visitor_name, address, contact_number, whom_to_visit, visit_date, visit_time) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, visitor_name);
            pstmt.setString(2, address);
            pstmt.setString(3, contact_number);
            pstmt.setString(4, whom_to_visit);
            pstmt.setDate(5, Date.valueOf(visit_date));
            pstmt.setTime(6, Time.valueOf(visit_time));

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Visitor data saved successfully.");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
