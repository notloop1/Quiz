import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsScreen {
    @FXML
    private RadioButton Theme1, Theme2, Theme3;

    public void initialize () {
        if (Information.chosenStyle == "Default") {
            Theme1.setSelected(true);
        }
        else if (Information.chosenStyle == "OceanBlue") {
            Theme2.setSelected(true);
        }
        else if (Information.chosenStyle == "BubblegumPink") {
            Theme3.setSelected(true);
        }
    }

    public void changeStyle (ActionEvent event) {
        if (Theme1.isSelected()) {
            Information.chosenStyle = "Default";
        }
        else if (Theme2.isSelected()) {
            Information.chosenStyle = "OceanBlue";
        }
        else if (Theme3.isSelected()) {
            Information.chosenStyle = "BubblegumPink";
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        String css = getClass().getResource("styles/" + Information.chosenStyle + ".css").toExternalForm();
        stage.getScene().getStylesheets().clear();
        stage.getScene().getStylesheets().add(css);
    }

    public void backButtonClicked (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene menuOptionsScene = new Scene(FXMLLoader.load(getClass().getResource("MenuOptions.fxml")));
        stage.setScene(menuOptionsScene);
        String css = getClass().getResource("styles/" + Information.chosenStyle + ".css").toExternalForm();
        menuOptionsScene.getStylesheets().add(css);
    }
}
