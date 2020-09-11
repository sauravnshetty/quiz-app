package quiz.Controller;

import javafx.scene.control.Alert;

public class MyRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MyRuntimeException (String msg){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Error!!!");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
