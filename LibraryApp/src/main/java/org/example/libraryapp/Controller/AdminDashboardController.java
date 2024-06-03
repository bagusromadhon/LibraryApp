package org.example.libraryapp.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.libraryapp.Model.Student;

public class AdminDashboardController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField nimField;

    @FXML
    private TextField fakultasField;

    @FXML
    private TextField programStudiField;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> nimColumn;

    @FXML
    private TableColumn<Student, String> fakultasColumn;

    @FXML
    private TableColumn<Student, String> programStudiColumn;

    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));
        fakultasColumn.setCellValueFactory(new PropertyValueFactory<>("fakultas"));
        programStudiColumn.setCellValueFactory(new PropertyValueFactory<>("programStudi"));

        studentTable.setItems(studentList);
    }

    @FXML
    protected void handleSubmitButtonAction() {
        String name = nameField.getText();
        String nim = nimField.getText();
        String fakultas = fakultasField.getText();
        String programStudi = programStudiField.getText();

        if (name.isEmpty() || nim.isEmpty() || fakultas.isEmpty() || programStudi.isEmpty()) {
            showAlert(AlertType.ERROR, "Input Error", "Please fill all fields.");
        } else {
            Student student = new Student(name, nim, fakultas, programStudi);
            studentList.add(student);
            showAlert(AlertType.INFORMATION, "Success", "Student data added successfully.");

            // Clear fields after submission
            nameField.clear();
            nimField.clear();
            fakultasField.clear();
            programStudiField.clear();
        }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
