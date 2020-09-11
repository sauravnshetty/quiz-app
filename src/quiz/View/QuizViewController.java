package quiz.View;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import quiz.Controller.MainController;
import quiz.Model.QuizQuestion;

public class QuizViewController {

    @FXML
    private Label question;
    @FXML
    private RadioButton option1, option2, option3, option4;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button backButton;
    @FXML
    private Button nextButton;
    @FXML
    private ToggleGroup radioGroup;
    private MainController mainApp;
    //private QuizQuestion ques;

    public QuizViewController() {
        radioGroup = new ToggleGroup();
    }

    @FXML
    public void initialize() {

        backButton.setDisable(true);
        option1.setToggleGroup(radioGroup);
        option2.setToggleGroup(radioGroup);
        option3.setToggleGroup(radioGroup);
        option4.setToggleGroup(radioGroup);
    }

    public void setMainApp(MainController mainApp) {
        this.mainApp = mainApp;
    }

    public void showQuestion(QuizQuestion ques) {

        //this.ques = ques;
        question.setText(ques.getQuestion());
        String[] allAnswers = ques.getAllAnswers();
        option1.setText(allAnswers[0]);
        option2.setText(allAnswers[1]);
        option3.setText(allAnswers[2]);
        option4.setText(allAnswers[3]);
    }

    @FXML
    public void onNextClicked() {

        String selected = ((RadioButton) radioGroup.getSelectedToggle()).getText();
        mainApp.checkAnswer(selected);
        if(mainApp.isGameOver()) {
            mainApp.showResultView();
        }
        else {
            mainApp.setNextQuestion();
            option1.setSelected(false);
            option2.setSelected(false);
            option3.setSelected(false);
            option4.setSelected(false);
        }
    }

    /*@FXML
    public void onBackClicked() {

        mainApp.setPreviousQuestion();
        RadioButton selected = (RadioButton) radioGroup.getSelectedToggle();
        mainApp.checkAndRevertScore(selected.getText());
    }*/
}
