import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {
    //TGHIS CLASS IS THE CONTROLLER
    @FXML
    private Text MainMenuTitle;
    @FXML
    private Button NextButton;

    private Stage stage;
    private Scene scene2;

    public void switch2QuizScene(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //the parameters are a parent (called root in the tutorial)
        scene2 = new Scene(FXMLLoader.load(getClass().getResource("QuizScene.fxml")));
        String css = getClass().getResource("Styles.css").toExternalForm();
        scene2.getStylesheets().add(css);
        stage.setScene(scene2);
    }
}
