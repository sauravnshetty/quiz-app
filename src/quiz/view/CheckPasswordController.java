package quiz.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import quiz.Controller.AdminWindow;

public class CheckPasswordController {

    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    private String password;

    public void setPassword(String password) { this.password  = password; }

    @FXML
    public void onLoginClicked() {

        if(this.password.equals(passwordField.getText()))
            AdminWindow.setAddQuestions();
    }
}
