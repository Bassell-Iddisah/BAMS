module com.example.bams {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.bams to javafx.fxml;
    exports com.example.bams;
}