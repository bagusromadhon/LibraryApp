package org.example.libraryapp.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import org.example.libraryapp.HelloApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloController {

    @FXML
    private TextField nimField;

    @FXML
    private PasswordField passwordField;

    private Map<String, String> studentCredentials = new HashMap<>();
    private Map<String, String> adminCredentials = new HashMap<>();

    public HelloController() {
        // Initial data
        studentCredentials.put("123456789012345", "password123");
        studentCredentials.put("987654321098765", "password987");
        adminCredentials.put("adminadminadmin", "adminpassword");
    }

    @FXML
    protected void handleLoginButtonAction() {
        String nim = nimField.getText();
        String password = passwordField.getText();

        if (nim.isEmpty() || password.isEmpty()) {
            showAlert(AlertType.ERROR, "Login Error", "Please enter your NIM and password.");
        } else {
            if (adminCredentials.containsKey(nim)) {
                if (adminCredentials.get(nim).equals(password)) {
                    loadDashboard("admin-dashboard.fxml", "Admin Dashboard");
                } else {
                    showAlert(AlertType.ERROR, "Login Error", "Invalid password for admin.");
                }
            } else if (nim.matches("\\d{15}")) {
                if (studentCredentials.containsKey(nim) && studentCredentials.get(nim).equals(password)) {
                    loadDashboard("student-dashboard.fxml", "Student Dashboard");
                } else {
                    showAlert(AlertType.ERROR, "Login Error", "Invalid NIM or password for student.");
                }
            } else {
                showAlert(AlertType.ERROR, "Login Error", "NIM must be exactly 15 digits for students.");
            }
        }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void loadDashboard(String fxmlFile, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/libraryapp/View/" + fxmlFile));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) nimField.getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Failed to load dashboard.");
        }
    }
}
