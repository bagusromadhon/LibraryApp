module org.example.libraryapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    opens org.example.libraryapp to javafx.fxml;
    opens org.example.libraryapp.Model to javafx.base;
    exports org.example.libraryapp;
    exports org.example.libraryapp.Controller;
    opens org.example.libraryapp.Controller to javafx.fxml;
}