package quiz.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import quiz.View.AddQuestionsController;
import quiz.View.CheckPasswordController;

import java.io.File;


public class AdminWindow {

    private static Stage adminWindow;
    private static AnchorPane passRoot;
    private static BorderPane addquesRoot;
    private static AddQuestionsController addQues;
    private static CheckPasswordController chkpsd;
    private static final String password = "menofculture";
    private static MainController parent;

    public static void authenticate() {
        try {
            adminWindow = new Stage();
            adminWindow.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader = new FXMLLoader(new File("/Users/saurav/IdeaProjects/QuizApp/src/quiz/View/CheckPassword.fxml").toURI().toURL());
            //loader.setLocation(AdminWindow.class.getResource("quiz/View/AddQuestions.fxml"));
            passRoot = loader.load();
            chkpsd = loader.getController();
            chkpsd.setPassword(password);
            Scene scene = new Scene(passRoot);
            adminWindow.setTitle("Add a question");
            adminWindow.setScene(scene);
            adminWindow.show();
        }
        catch (Exception e) {
            throw new MyRuntimeException(e.getMessage());
        }
    }

    public static void setAddQuestions() {

        try {
            FXMLLoader loader = new FXMLLoader(new File("/Users/saurav/IdeaProjects/QuizApp/src/quiz/View/AddQuestions.fxml").toURI().toURL());
            //loader.setLocation(AdminWindow.class.getResource("quiz/View/AddQuestions.fxml"));
            addquesRoot = loader.load();
            addQues = loader.getController();
            addQues.setMainApp(parent);
            Scene scene = new Scene(addquesRoot);
            adminWindow.setTitle("Add a question");
            adminWindow.setScene(scene);
            adminWindow.show();
        }
        catch (Exception e) {
            throw new MyRuntimeException(e.getMessage());
        }
    }

    public static void setMainApp(MainController mainApp) { parent = mainApp; }

    //public static QuizQuestion getQuizQuestion() { return addQues.getQuizQuestion(); }
}
