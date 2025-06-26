module jsnn.jsnn {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires java.desktop;

    opens jsnn.jsnn to javafx.fxml;
    exports jsnn.jsnn;
    exports jsnn.jsnn.viewModels;
    opens jsnn.jsnn.viewModels to javafx.fxml;
}