module jsnn.jsnn {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens jsnn.jsnn to javafx.fxml;
    exports jsnn.jsnn;
}