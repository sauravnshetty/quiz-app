package quiz.view;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import quiz.Controller.MainController;


public class InfoViewController {

    @FXML
    private Label infoLabel;
    @FXML
    private Button backButton;
    private final String textInfo = "Sorry to inform, but there's no such thing as animen't quiz\n" +
                                    "If you want to play this quiz or if you want to be cool like\n"+
                                    "the guy who made this app, then here's a list of anime you can watch :\n" +
                                    "-> Death Note\n" + "-> Attack On Titan\n" + "-> Your lie in April\n" +
                                    "-> Koe no katachi (A silent voice)\n" + "-> Your name\n";

    private final String tierInfo = "\nTier description :\n" + "-> Tier 3: A Noob, mostly watched only few famous anime\n" +
                                    "-> Tier 2: A little superior to teir 1, might be a little familiar with the community\n" +
                                    "-> Tier 1: Has waifus, often called degenerate and creepy by society, anime is daily rountine\n" +
                                    "-> Tier 0: True man of culture, has deep knowledge and is considered to be more creepy and degenerate than tier 1\n";
    private MainController mainApp;

    public void setMainApp(MainController mainApp) { this.mainApp = mainApp; }

    public void setTextInfoView() {
        infoLabel.setText(textInfo);
    }

    public void setTierInfoView() {
        infoLabel.setText(tierInfo);
    }

    @FXML
    public void onBackButtonClicked() {

        mainApp.showFirstView();
    }
}
