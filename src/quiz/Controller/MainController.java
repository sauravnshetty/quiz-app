package quiz.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import quiz.Model.FileHandler;
import quiz.Model.QuizGame;
import quiz.Model.QuizQuestion;
import quiz.View.FirstViewController;
import quiz.View.InfoViewController;
import quiz.View.MenuController;
import quiz.View.QuizViewController;
import java.io.File;
import java.io.IOException;

public class MainController extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private MenuController menu;
    private FirstViewController firstView, resultView;
    private QuizViewController quizView;
    private InfoViewController infoView;
    private QuizGame quizGame;
    private int score;
    private String title, message;

    private static final String filename = "quizQuestions.ser";
    private static final String countFile = "count.txt";

    private static final FileHandler filehandler = new FileHandler(filename,countFile);

    public MainController() {
        title = "Quiz App";
        score = 0;
    }

    private static void log(String s) { System.out.println(s); }

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("Quiz App");
            initRootLayout();
            showFirstView();
        }
        catch(Exception e) {
            throw new MyRuntimeException(e.getMessage());
        }
    }

    private void initRootLayout() {

        try {
            FXMLLoader loader = new FXMLLoader(new File("/Users/saurav/IdeaProjects/QuizApp/src/quiz/View/Menu.fxml").toURI().toURL());
            //URL location = getClass().getResource("quiz.View/Menu.fxml");
            //System.out.println(location);
            //System.out.println("Hello world");
            //loader.setLocation(MainController.class.getResource("quiz/View/Menu.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            menu = loader.getController();
            menu.setMainApp(this);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        }
        catch (IOException e) {
            throw new MyRuntimeException(e.getMessage());
        }
    }

    public void showFirstView() {

        try {
            FXMLLoader loader = new FXMLLoader(new File("/Users/saurav/IdeaProjects/QuizApp/src/quiz/View/FirstView.fxml").toURI().toURL());
            AnchorPane layout = loader.load();
            rootLayout.setCenter(layout);
            firstView = loader.getController();
            firstView.setMainApp(this);
            firstView.setTitle(title);
            firstView.setFirstView();
        }
        catch(Exception e) {
            throw new MyRuntimeException(e.getMessage());
        }
    }

    public void showInfoView(boolean defaultInfo) {

        try{
            FXMLLoader loader = new FXMLLoader(new File("/Users/saurav/IdeaProjects/QuizApp/src/quiz/View/InfoView.fxml").toURI().toURL());
            BorderPane layout = loader.load();
            rootLayout.setCenter(layout);
            infoView = loader.getController();
            infoView.setMainApp(this);
            if(defaultInfo)
                infoView.setTierInfoView();
            else
                infoView.setTextInfoView();
        }
        catch (Exception e) {
            throw new MyRuntimeException(e.getMessage());
        }
    }

    public void createAdminWindow() {

        AdminWindow.authenticate();
        AdminWindow.setMainApp(this);
    }

    public void createGame() {

        quizGame = filehandler.importQuiz();
        score = 0;
    }

    public void addQuestion(QuizQuestion ques) {

        filehandler.addQuestions(ques);
    }

    public void loadQuizView() {

        try{
            FXMLLoader loader = new FXMLLoader(new File("/Users/saurav/IdeaProjects/QuizApp/src/quiz/View/QuizView.fxml").toURI().toURL());
            BorderPane layout = loader.load();
            rootLayout.setCenter(layout);
            quizView = loader.getController();
            quizView.setMainApp(this);
            quizView.showQuestion(quizGame.getQuestion());
        }
        catch(Exception e) {
            throw new MyRuntimeException(e.getMessage());
        }
    }

    public void checkAnswer(String answer) {

        log("Answer you selected : "+ answer);
        if(answer.equalsIgnoreCase(quizGame.getCorrect()))
            score++;
        log("Score : " + score);
    }

    /*public void checkAndRevertScore(String answer) {//correct the score value while going back to previous questions

        if(answer == quizGame.getCorrect())
            score--;
    }*/

    public void setNextQuestion() {

        quizGame.incIndex();
        quizView.showQuestion(quizGame.getQuestion());
    }

    /*public void setPreviousQuestion() {

        quizGame.decIndex();
        quizView.showQuestion(quizGame.getQuestion());
    }*/

    public boolean isGameOver() {
        return quizGame.isGameOver();
    }

    public void showResultView() {

        title = "Your score is " + score + " out of " + quizGame.getCountQuestions() ;
        int points = (int)score * QuizGame.getNoOfQuestions() / quizGame.getCountQuestions();
        switch (points) {
            case 0:
            case 1:
            case 2: message = "You're a Tier 3 weeb";
                    break;
            case 3:
            case 4:
            case 5: message = "You're a Tier 2 weeb";
                    break;
            case 6:
            case 7:
            case 8: message = "You're a Tier 1 weeb";
                    break;
            case 9:
            case 10: message = "You're a Tier 0 weeb";
                     break;
        }
        try {
            FXMLLoader loader = new FXMLLoader(new File("/Users/saurav/IdeaProjects/QuizApp/src/quiz/View/FirstView.fxml").toURI().toURL());
            AnchorPane layout = loader.load();
            rootLayout.setCenter(layout);
            resultView = loader.getController();
            resultView.setMainApp(this);
            resultView.setTitle(title);
            resultView.setSubtitle(message);
            resultView.setResultView();
        }
        catch(Exception e) {
            throw new MyRuntimeException(e.getMessage());
        }
    }

    public void closeApp(){

        primaryStage.close();
    }

}
