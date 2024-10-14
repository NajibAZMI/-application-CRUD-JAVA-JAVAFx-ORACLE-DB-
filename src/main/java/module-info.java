module com.example.crud_in_java {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.crud_in_java to javafx.fxml;
    exports com.example.crud_in_java;
}