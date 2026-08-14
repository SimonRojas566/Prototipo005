module pe.edu.upeu.prototipocodigo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens pe.edu.upeu.prototipocodigo to javafx.fxml;
    exports pe.edu.upeu.prototipocodigo;
}