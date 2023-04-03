module com.example.trackinglivreur {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.trackinglivreur to javafx.fxml;
    exports com.example.trackinglivreur;

    requires java.sql;

}