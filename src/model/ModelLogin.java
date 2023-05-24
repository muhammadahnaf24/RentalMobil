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
    private String usernameModel;
    private String passwordModel;
    
    private Connection connection;
    
    public String getUsernameModel() {
        return usernameModel;
    }

    public void setUsernameModel(String usernameModel) {
        this.usernameModel = usernameModel;
    }

    public String getPasswordModel() {
        return passwordModel;
    }

    public void setPasswordModel(String passwordModel) {
        this.passwordModel = passwordModel;
    }
    public ModelLogin() {
        Koneksi koneksi = new Koneksi();
        connection = koneksi.getConnection();
    }
    
     public void login() {
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, getUsernameModel());
            statement.setString(2, getPasswordModel());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Login Berhasil");
                ViewMenuUtama MU = new ViewMenuUtama();
                MU.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password Salah");
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Login Gagal \n" + ex);
        }
    }
}