import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuOptions {
    @FXML
    private Stage stage;

    @FXML
    private Scene gameScene;


    public void switch2QuizScenes(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        gameScene = new Scene(FXMLLoader.load(getClass().getResource("QuizScene.fxml")));
        stage.setScene(gameScene);
        String css = getClass().getResource("styles/" + Information.chosenStyle + ".css").toExternalForm();
        gameScene.getStylesheets().add(css);
    }

    public void switch2ScoresScreen(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        gameScene = new Scene(FXMLLoader.load(getClass().getResource("ScoresScreen.fxml")));
        stage.setScene(gameScene);
        String css = getClass().getResource("styles/" + Information.chosenStyle + ".css").toExternalForm();
        gameScene.getStylesheets().add(css);
    }

    public void switch2SettingsScreen(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        gameScene = new Scene(FXMLLoader.load(getClass().getResource("SettingsScreen.fxml")));
        stage.setScene(gameScene);
        String css = getClass().getResource("styles/" + Information.chosenStyle + ".css").toExternalForm();
        gameScene.getStylesheets().add(css);
    }
}
