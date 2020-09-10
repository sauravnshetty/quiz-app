package quiz.view;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import quiz.Controller.MainController;
import quiz.model.QuizQuestion;
import javafx.scene.control.TextField;

public class AddQuestionsController {

    @FXML
    private TextField questionField;
    @FXML
    private  TextField correctField;
    @FXML
    private  TextField option1Field;
    @FXML
    private  TextField option2Field;
    @FXML
    private  TextField option3Field;
    @FXML
    private  TextField option4Field;

    private QuizQuestion quizQuestion ;
    private MainController mainApp;

    @FXML
    private void onSubmitClicked() {

        quizQuestion = new QuizQuestion();
        quizQuestion.setQuestion(questionField.getText());
        quizQuestion.setCorrect(correctField.getText());
        String[] allAnswers = {option1Field.getText(), option2Field.getText(), option3Field.getText(), option4Field.getText()};
        quizQuestion.setAllAnswers(allAnswers);
        questionField.clear();
        correctField.clear();
        option1Field.clear();
        option2Field.clear();
        option3Field.clear();
        option4Field.clear();
        mainApp.addQuestion(quizQuestion);
    }

    public void setMainApp(MainController mainApp) { this.mainApp = mainApp; }

    /* QuizQuestion getQuizQuestion() {
        return quizQuestion;
    }*/
}
