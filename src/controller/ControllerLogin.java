/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.ModelLogin;
import view.ViewLogin;
/**
 *
 * @author M S I
 */
public class ControllerLogin {
    private ViewLogin VL;
    private ModelLogin ML;

    public ControllerLogin(ViewLogin view) {
        this.VL = view; 

    }

    public void login() {
        ML = new ModelLogin();
        ML.setUsernameModel(VL.getTFUsername().getText());
        ML.setPasswordModel(VL.getTFPassword().getText());

        ML.login();
    }
   
    
    public void cancel(){
        VL.getTFUsername().setText("");
        VL.getTFPassword().setText("");
    }
}
    

