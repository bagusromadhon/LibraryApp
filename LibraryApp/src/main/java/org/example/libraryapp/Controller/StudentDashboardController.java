package org.example.libraryapp.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class StudentDashboardController {

    @FXML
    protected void handleShowBorrowedBooks() {
        // Show borrowed books logic here
        showAlert(AlertType.INFORMATION, "Show Borrowed Books", "Show borrowed books functionality not implemented.");
    }

    @FXML
    protected void handleBorrowBook() {
        // Borrow book logic here
        showAlert(AlertType.INFORMATION, "Borrow Book", "Borrow book functionality not implemented.");
    }

    @FXML
    protected void handleReturnBook() {
        // Return book logic here
        showAlert(AlertType.INFORMATION, "Return Book", "Return book functionality not implemented.");
    }

    @FXML
    protected void handleLogout() {
        // Logout logic here
        showAlert(AlertType.INFORMATION, "Logout", "Logout functionality not implemented.");
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
