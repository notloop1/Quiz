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

public class MainMenu {
    //THIS CLASS IS THE CONTROLLER

    @FXML
    private Stage stage;
    @FXML
    private Scene scene2;

    @FXML
    private TextField usernameTextField;

    public void switch2MenuOptions(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //the parameters are a parent (called root in code bro's the tutorial)
        scene2 = new Scene(FXMLLoader.load(getClass().getResource("MenuOptions.fxml")));
        stage.setScene(scene2);
        String css = getClass().getResource("Styles.css").toExternalForm();
        scene2.getStylesheets().add(css);

        Information.username = usernameTextField.getText();
        Path userFilePath = Paths.get("src/userData/" + Information.username + ".txt");

        if (!Files.exists(userFilePath)) {
            Files.createFile(userFilePath);
        }
    }
}
