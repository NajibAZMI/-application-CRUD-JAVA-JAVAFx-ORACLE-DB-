package com.example.crud_in_java;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField usernameField;;
    @FXML
    private PasswordField passwordField;
    @FXML
    private void handleLogin() {

        String username = usernameField.getText();
        String password = passwordField.getText();


        System.out.println("Username: " + username);
        System.out.println("Password: " + password);


    }
}