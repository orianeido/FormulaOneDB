module com.example.formulaone {

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;
    requires javafx.fxml;

    opens com.example.formulaone.Model;
    opens com.example.formulaone.Controller to javafx.fxml ;

    opens com.example.formulaone to javafx.fxml;
    exports com.example.formulaone;
}