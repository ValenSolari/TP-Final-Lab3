module com.example.demo4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.demo4 to javafx.fxml;
    exports com.example.demo4;
    exports com.example.demo4.ui;
    opens com.example.demo4.ui to javafx.fxml;
    exports com.example.demo4.Clases to com.fasterxml.jackson.databind;

}