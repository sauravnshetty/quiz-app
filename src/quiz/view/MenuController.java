package quiz.view;

import javafx.fxml.FXML;
import quiz.Controller.MainController;

public class MenuController {

    private MainController mainApp;

    public void setMainApp(MainController mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void onAddQuestionsClicked() {

        mainApp.createAdminWindow();
    }

    @FXML
    private void onTierInfoClicked() {

        mainApp.showInfoView(true);
    }
}
