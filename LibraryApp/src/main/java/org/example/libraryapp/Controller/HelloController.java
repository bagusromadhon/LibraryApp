package org.example.libraryapp.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HelloController {

    @FXML
    private TextField nimField;

    @FXML
    private PasswordField passwordField;

    private Map<String, String> credentials = new HashMap<>();

    public HelloController() {
        // Initial data
        credentials.put("123456789012345", "password123");
        credentials.put("987654321098765", "password987");
        credentials.put("123451234512345", "password111");
        credentials.put("adminadminadmin", "adminpassword");
    }

    @FXML
    protected void handleLoginButtonAction() {
        String nim = nimField.getText();
        String password = passwordField.getText();

        if (nim.isEmpty() || password.isEmpty()) {
            showAlert(AlertType.ERROR, "Login Error", "Please enter your NIM and password.");
        } else if (!nim.matches("\\d{15}")) {
            showAlert(AlertType.ERROR, "Login Error", "NIM must be exactly 15 digits.");
        } else {
            if (credentials.containsKey(nim) && credentials.get(nim).equals(password)) {
                showAlert(AlertType.INFORMATION, "Login Success", "Password sesuai.");
            } else {
                showAlert(AlertType.ERROR, "Login Error", "Password tidak sesuai.");
            }
        }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
