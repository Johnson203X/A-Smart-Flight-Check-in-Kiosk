/**
 * Module management ebu.groupone.iteration
 */
module ebu.groupone.iteration {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires fastjson;
    requires org.testng;

    opens ebu.groupone.iteration to javafx.fxml;
    opens ebu.groupone.iteration.Controller to javafx.fxml;
    opens ebu.groupone.iteration.Control to org.testing;
    opens ebu.groupone.iteration.Model to fastjson;

    exports ebu.groupone.iteration;
    exports ebu.groupone.iteration.Model;
    exports ebu.groupone.iteration.Control;
    exports ebu.groupone.iteration.Controller;

}
