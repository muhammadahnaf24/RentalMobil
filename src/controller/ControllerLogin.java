/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.ModelLogin;
import view.ViewLogin;
/**
 *
 * @author M S I
 */
public class ControllerLogin {
    private ViewLogin view;
    private ModelLogin model;

    public ControllerLogin(ViewLogin view, ModelLogin model) {
        this.view = view;
        this.model = model;

        // Attach action listener to the login button
        view.getBtnLogin().addActionListener(e -> login());
    }

    private void login() {
        String username = view.getUsername();
        String password = view.getPassword();

        if (model.login(username, password)) {
            // Login successful, do something
        } else {
            // Login failed, display an error message
        }
    }
}
    

