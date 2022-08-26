import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class MainMenu {
    //TGHIS CLASS IS THE CONTROLLER

    @FXML
    private Stage stage;
    @FXML
    private Scene scene2;

    public void switch2MenuOptions(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //the parameters are a parent (called root in code bro's the tutorial)
        scene2 = new Scene(FXMLLoader.load(getClass().getResource("MenuOptions.fxml")));
        stage.setScene(scene2);
        String css = getClass().getResource("Styles.css").toExternalForm();
        scene2.getStylesheets().add(css);

    }
}
