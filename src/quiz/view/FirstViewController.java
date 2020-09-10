package quiz.view;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import quiz.Controller.MainController;

public class FirstViewController {

    private MainController mainApp;
    @FXML
    private Button startButton, quitButton, animent;
    @FXML
    private Label label, subtitle;

    @FXML
    public void initialize() {

        label.setText("");
        subtitle.setText("");
        startButton.setDisable(true);
        startButton.setVisible(false);
        quitButton.setVisible(false);
        quitButton.setDisable(true);
        animent.setDisable(true);
        animent.setVisible(false);
    }

    public void setMainApp(MainController mainApp) {
        this.mainApp = mainApp;
    }

    public void setTitle(String title) {
        label.setText(title);
    }

    public void setSubtitle(String subtitleMessage) {
        subtitle.setText(subtitleMessage);
        //subtitle.setMaxWidth(500);
        //subtitle.setMaxHeight(150);
        //subtitle.setWrapText(true);

    }

    @FXML
    public void onStartButtonClicked() {

        mainApp.createGame();
        mainApp.loadQuizView();
    }

    @FXML
    public void onAnimentClicked() {

        mainApp.showInfoView(false);
    }

    @FXML
    public void onQuitButtonCLicked() {
        mainApp.closeApp();
    }

    public void setFirstView() {

        startButton.setText("Anime quiz");
        startButton.setVisible(true);
        startButton.setDisable(false);
        animent.setDisable(false);
        animent.setVisible(true);
        quitButton.setDisable(false);
        quitButton.setVisible(true);
    }

    public void setResultView() {

        quitButton.setVisible(true);
        quitButton.setDisable(false);
        startButton.setText("Play again");
        startButton.setVisible(true);
        startButton.setDisable(false);
        animent.setDisable(false);
        animent.setVisible(true);
    }
}
