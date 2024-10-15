package com.example.crud_in_java;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.Alert;
import java.sql.SQLException;

public class HelloController {
    @FXML
    private TextField usernameField;  // Doit correspondre à fx:id dans le FXML

    @FXML
    private PasswordField passwordField;  // Doit correspondre à fx:id dans le FXML

    @FXML

    private void handleLogin() {
        System.out.println("Le bouton a été cliqué !");

        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // DB
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe"; // Remplacez par votre URL JDBC
        String dbUsername = "system"; // Remplacez par votre nom d'utilisateur de base de données
        String dbPassword = "najib123"; // Remplacez par votre mot de passe de base de données

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
            System.out.println("Connexion réussie !");

            String sql = "SELECT * FROM CLIENT WHERE EMAIL = ? AND PASSWORD = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();

                // Vérification des résultats
                if (resultSet.next()) {
                    showAlert("Bienvenue!", "Connexion réussie !");
                } else {
                    showAlert("Erreur", "Nom d'utilisateur ou mot de passe incorrect.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion : " + e.getErrorCode() + " - " + e.getMessage());
            showAlert("Erreur", "Une erreur s'est produite lors de la connexion à la base de données : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Erreur", "Une erreur inattendue s'est produite : " + e.getMessage());
        }
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
