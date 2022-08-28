
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MenuOptions {
        @FXML
        private Stage stage;

        @FXML
        private Scene gameScene;


        public void switch2QuizScenes(javafx.event.ActionEvent actionEvent) throws IOException {
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                gameScene = new Scene(FXMLLoader.load(getClass().getResource("QuizScene.fxml")));
                stage.setScene(gameScene);
                String css = getClass().getResource("Styles.css").toExternalForm();
                gameScene.getStylesheets().add(css);

        }

        public void switch2ScoresScreen(javafx.event.ActionEvent actionEvent) throws IOException {
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                gameScene = new Scene(FXMLLoader.load(getClass().getResource("ScoresScreen.fxml")));
                stage.setScene(gameScene);
                String css = getClass().getResource("Styles.css").toExternalForm();
                gameScene.getStylesheets().add(css);

        }

        public void switch2SettingsScreen(ActionEvent actionEvent) throws IOException {
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                gameScene = new Scene(FXMLLoader.load(getClass().getResource("ScoresScreen.fxml")));
                stage.setScene(gameScene);
                String css = getClass().getResource("Styles.css").toExternalForm();
                gameScene.getStylesheets().add(css);
        }
}
