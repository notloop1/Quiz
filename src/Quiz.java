import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Quiz extends Application {

    public static void main (String args []) {
        launch (args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //create a scene, one needed for each page of the quiz
        Scene scene1 = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        stage.setScene(scene1);
        String css = getClass().getResource("Styles.css").toExternalForm();
        scene1.getStylesheets().add(css);
        stage.show();
    }
}
