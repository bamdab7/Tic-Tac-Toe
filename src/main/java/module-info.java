module com.example.tiktaktoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.tiktaktoe to javafx.fxml;
    exports com.example.tiktaktoe;
}