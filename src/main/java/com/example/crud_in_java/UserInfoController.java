package com.example.crud_in_java;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class UserInfoController {
    @FXML
    private Label usernameLabel;

    @FXML
    private Label emailLabel;

    public void setUserInfo(String username, String email) {
        usernameLabel.setText("Nom d'utilisateur : " + username);
        emailLabel.setText("Email : " + email);
    }
}
