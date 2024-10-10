module group16.smartflightcheckinkiosk {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.logging;
    requires junit;

    opens group16.smartflightcheckinkiosk to javafx.fxml;
    exports group16.smartflightcheckinkiosk;
    exports group16.smartflightcheckinkiosk.Controller;
    opens group16.smartflightcheckinkiosk.Controller to javafx.fxml;
    exports group16.smartflightcheckinkiosk.Data;
    opens group16.smartflightcheckinkiosk.Data to javafx.fxml;
}