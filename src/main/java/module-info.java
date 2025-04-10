module com.example.tryfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.example.tryfx to javafx.fxml;
    exports com.example.tryfx;
}