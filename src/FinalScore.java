 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.Label;
 import javafx.scene.control.ProgressBar;

 import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.nio.file.StandardOpenOption;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.List;

 public class FinalScore {
     @FXML
     private ProgressBar progressBar;

     @FXML
     private Label scoreDisplay;

     public void initialize() throws IOException {
         progressBar.setProgress(Information.progressScore);

         System.out.println(Information.score);
         scoreDisplay.setText(String.valueOf(Information.score));

         saveScoreToFile();
     }

     private void saveScoreToFile() throws IOException {
         Path userFilePath = Paths.get("src/userData/" + Information.username + ".txt");
         //intstead of array and contents n\
         List<String> info = Files.readAllLines(userFilePath);

         Date currentDate = new Date();
         SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/YY");
         String formattedDate = dateFormatter.format(currentDate);
         Files.writeString(userFilePath, formattedDate + " " + Information.score + "\n", StandardOpenOption.APPEND);

         for (int i = 0; i < info.size(); i++) {
             String[] line = info.get(i).split(" ");
             System.out.println("Score is" + line[1]);
             System.out.println("Date is" + line[0]);
         }
     }
 }
