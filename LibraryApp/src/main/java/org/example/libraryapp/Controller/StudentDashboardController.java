package org.example.libraryapp.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.libraryapp.Model.Book;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class StudentDashboardController implements Initializable {

    @FXML
    private TableView<Book> availableBooksTable;

    @FXML
    private TableColumn<Book, String> availableBookIdColumn;

    @FXML
    private TableColumn<Book, String> availableTitleColumn;

    @FXML
    private TableColumn<Book, String> availableAuthorColumn;

    @FXML
    private TableColumn<Book, String> availableCategoryColumn;

    @FXML
    private TableColumn<Book, Integer> availableStockColumn;

    @FXML
    private TableColumn<Book, Integer> availableDurationColumn;

    @FXML
    private TextField bookIdField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField stockField;

    @FXML
    private TextField durationField;

    @FXML
    private TextField borrowerNIMField;

    @FXML
    private TableView<Book> borrowedBooksTable;

    @FXML
    private TableColumn<Book, String> borrowedBookIdColumn;

    @FXML
    private TableColumn<Book, String> borrowedTitleColumn;

    @FXML
    private TableColumn<Book, String> borrowedAuthorColumn;

    @FXML
    private TableColumn<Book, String> borrowedCategoryColumn;

    @FXML
    private TableColumn<Book, Integer> borrowedStockColumn;

    @FXML
    private TableColumn<Book, Integer> borrowedDurationColumn;

    @FXML
    private TableColumn<Book, String> borrowerNIMColumn;

    private ObservableList<Book> bookList = FXCollections.observableArrayList();
    private Book selectedBook;
    private String studentNIM = "123456";  // Nim user student yang login, harus didapatkan dari sesi user yang login.

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize columns for availableBooksTable
        availableBookIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        availableTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        availableAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        availableCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        availableStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        availableDurationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        // Initialize columns for borrowedBooksTable
        borrowedBookIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        borrowedTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        borrowedAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        borrowedCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        borrowedStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        borrowedDurationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        borrowerNIMColumn.setCellValueFactory(new PropertyValueFactory<>("borrowerNIM"));

        // Sample Data
        bookList.add(new Book("1", "Book One", "Author A", "History Book", 5, 7, "Tidak Ada"));
        bookList.add(new Book("2", "Book Two", "Author B", "Story Book", 3, 14, "123456789012345"));
        bookList.add(new Book("3", "Book Three", "Author C", "Text Book", 2, 21, "Tidak Ada"));
        bookList.add(new Book("4", "Book Four", "Author D", "Story Book", 4, 10, "678901234567890"));

        // Filter books for availableBooksTable and borrowedBooksTable
        updateTables();

        availableBooksTable.setItems(getAvailableBooks());
        borrowedBooksTable.setItems(getBorrowedBooks());
    }

    private void updateTables() {
        availableBooksTable.setItems(getAvailableBooks());
        borrowedBooksTable.setItems(getBorrowedBooks());
    }

    private ObservableList<Book> getAvailableBooks() {
        return FXCollections.observableArrayList(
                bookList.stream().filter(book -> book.getBorrowerNIM().equals("Tidak Ada")).collect(Collectors.toList())
        );
    }

    private ObservableList<Book> getBorrowedBooks() {
        return FXCollections.observableArrayList(
                bookList.stream().filter(book -> !book.getBorrowerNIM().equals("Tidak Ada")).collect(Collectors.toList())
        );
    }

    @FXML
    private void handleBookSelection(MouseEvent event) {
        selectedBook = availableBooksTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            bookIdField.setText(selectedBook.getBookId());
            titleField.setText(selectedBook.getTitle());
            authorField.setText(selectedBook.getAuthor());
            categoryField.setText(selectedBook.getCategory());
            stockField.setText(String.valueOf(selectedBook.getStock()));
            durationField.setText(String.valueOf(selectedBook.getDuration()));
            borrowerNIMField.setText(selectedBook.getBorrowerNIM());
        }
    }

    @FXML
    private void handleBorrowBook() {
        if (selectedBook != null) {
            selectedBook.setBorrowerNIM(studentNIM);
            updateTables();
            clearForm();
        }
    }

    private void clearForm() {
        bookIdField.clear();
        titleField.clear();
        authorField.clear();
        categoryField.clear();
        stockField.clear();
        durationField.clear();
        borrowerNIMField.clear();
        selectedBook = null;
    }
}
