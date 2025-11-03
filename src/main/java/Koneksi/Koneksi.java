/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Koneksi {
    private static Connection conn;

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/siramdb";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi Berhasil.");
            return conn;
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
            return null;
        }
    }
}