import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
//
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuizScene {
    @FXML
    private Button Button0, Button1, Button2, Button3;

    List<Button> buttons = new ArrayList<>();
    List<String> shapesList = new ArrayList<>();
    List<String> selectedShapesList = new ArrayList<>();
    int correctIndex;
    Button correctButton;
    String correctShape;

    @FXML
    Label scoreLabel;

    @FXML
    Label question;

    @FXML
    public ImageView imageView0, imageView1, imageView2, imageView3;

    @FXML
    public void initialize() {
        buttons.add(Button0);
        buttons.add(Button1);
        buttons.add(Button2);
        buttons.add(Button3);

        shapesList.add("Rectangle");
        shapesList.add("Ellipse");
        shapesList.add("Hexagon");
        shapesList.add("Parallelogram");
        shapesList.add("Pyramid");
        shapesList.add("Rhombus");
        shapesList.add("Triangle");
        shapesList.add("Circle");
        shapesList.add("Star");
        shapesList.add("Heptagon");
        shapesList.add("Heart");
        shapesList.add("Arrow");
        shapesList.add("Crescent");
        shapesList.add("Cylinder");
        shapesList.add("Right_Triangle");
        shapesList.add("Semicircle");
        shapesList.add("Square");
        shapesList.add("Star");
//        shapesList.add("Trapezoid");

        generateQA();
    }

    private void generateQA() {
        Random generator = new Random();
        selectedShapesList.clear();

        for (int x = 0; x <= 3; x++) {
            String newAnswer;
            do {
                int randomNumber = generator.nextInt(shapesList.size());
                newAnswer = shapesList.get(randomNumber);
            } while (selectedShapesList.contains(newAnswer));

            selectedShapesList.add(newAnswer);
        }

        imageView0.setImage(new Image(getClass().getResourceAsStream("assets/" + selectedShapesList.get(0) + ".png")));
        imageView1.setImage(new Image(getClass().getResourceAsStream("assets/" + selectedShapesList.get(1) + ".png")));
        imageView2.setImage(new Image(getClass().getResourceAsStream("assets/" + selectedShapesList.get(2) + ".png")));
        imageView3.setImage(new Image(getClass().getResourceAsStream("assets/" + selectedShapesList.get(3) + ".png")));

        correctIndex = generator.nextInt(4);
        correctButton = buttons.get(correctIndex);
        correctShape = selectedShapesList.get(correctIndex); //name of correct shape

        question.setText("Which shape is the " + correctShape + "?");

        scoreLabel.setText("Score: " + Information.score);
    }


    @FXML
    public void buttonClicked (ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource(); //casting of button
        Information.counter +=1;

        if (clickedButton == correctButton) {
            // Got the Stage to be able to change scenes
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

            Information.score += 5;
            Information.progressScore += 0.05;

            if (Information.counter <= 3) {
                generateQA();
            } else {
                // Goto the score scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FinalScore.fxml"));
                Parent parent = loader.load();
                String css = getClass().getResource("Styles.css").toExternalForm();
                Scene FinalScore = new Scene(parent);
                FinalScore.getStylesheets().add(css);
                stage.setScene(FinalScore);
            }
        } else {
            generateQA();
        }

    }
}