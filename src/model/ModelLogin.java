/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.Koneksi;
import java.sql.*;
import javax.swing.*;
import view.ViewMenuUtama;
/**
 *
 * @author M S I
 */
public class ModelLogin {
    private Connection connection;
    
    public ModelLogin() {
        Koneksi koneksi = new Koneksi();
        connection = koneksi.getConnection();
    }
    
    public boolean login(String username, String password) {
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Login Berhasil");
                ViewMenuUtama menuUtama = new ViewMenuUtama();
                menuUtama.setVisible(true);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Username atau password salah");
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
}