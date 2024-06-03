module org.example.libraryapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.libraryapp to javafx.fxml;
    exports org.example.libraryapp;
    exports org.example.libraryapp.Controller;
    opens org.example.libraryapp.Controller to javafx.fxml;
}