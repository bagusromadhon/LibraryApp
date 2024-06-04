package org.example.libraryapp.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.libraryapp.Model.Book;
import org.example.libraryapp.Model.Student;

import java.io.IOException;

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

    @FXML
    private TextField bookIdField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private ChoiceBox<String> categoryChoiceBox;

    @FXML
    private TextField borrowerNIMField;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField stockField;

    @FXML
    private TextField durationField;

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<Book, String> bookIdColumn;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> categoryColumn;

    @FXML
    private TableColumn<Book, Integer> stockColumn;

    @FXML
    private TableColumn<Book, Integer> durationColumn;

    @FXML
    private TableColumn<Book, String> borrowerNIMColumn;

    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    private ObservableList<Student> studentList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        bookIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        categoryChoiceBox.setItems(FXCollections.observableArrayList("History Book", "Story Book", "Text Book"));


        bookTable.setItems(bookList);
    }

    @FXML
    protected void handleBookSubmitButtonAction() {
        String bookId = bookIdField.getText();
        String title = titleField.getText();
        String author = authorField.getText();
        String category = categoryChoiceBox.getValue();
        int stock = Integer.parseInt(stockField.getText());
        int duration = Integer.parseInt(durationField.getText());
        String borrowerNIM = borrowerNIMField.getText();

        if (bookId.isEmpty() || title.isEmpty() || author.isEmpty() || category == null || stockField.getText().isEmpty() || durationField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill all fields.");
        } else {
            Book book = new Book(bookId, title, author, category, stock, duration, borrowerNIM);
            bookList.add(book);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Book data added successfully.");


            bookIdField.clear();
            titleField.clear();
            authorField.clear();
            categoryChoiceBox.getSelectionModel().clearSelection();
            stockField.clear();
            durationField.clear();
            borrowerNIMField.setText("Tidak Ada");
        }
    }


    @FXML
    public void initializeBook() {
        bookIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        borrowerNIMColumn.setCellValueFactory(new PropertyValueFactory<>("borrowerNIM"));

        bookTable.setItems(bookList);

        categoryChoiceBox.setItems(FXCollections.observableArrayList("History Book", "Story Book", "Text Book"));
        borrowerNIMField.setText("Tidak Ada");
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

    @FXML
    protected void handleLogoutButtonAction() {
        try {
            Stage stage = (Stage) bookIdField.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/libraryapp/View/hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Logout Error", "Failed to load login view.");
            e.printStackTrace();
        }
    }


    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
