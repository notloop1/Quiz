 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.Label;
 import javafx.scene.control.ProgressBar;

 import java.io.IOException;
 import java.net.URL;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.nio.file.StandardOpenOption;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.List;
 import java.util.ResourceBundle;




 public class FinalScore implements Initializable {

     @FXML
     private ProgressBar progressBar;

     @FXML
     private Label scoreDisplay;

     @Override
     public void initialize(URL url, ResourceBundle resourceBundle) {
         progressBar.setStyle("-fx-accent: #C5FBC8;");
         progressBar.setProgress(Information.progressScore);

         scoreDisplay.setText(String.valueOf(Information.score));

         Path userFilePath = Paths.get("src/userData/" + Information.username + ".txt");
         //intstead of array and contents n\
         List<String> info = null;
         try {
             info = Files.readAllLines(userFilePath);
         } catch (IOException e) {
             e.printStackTrace();
         }

         Date currentDate = new Date();
         SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/YY");
         String formattedDate = dateFormatter.format(currentDate);
         try {
             Files.writeString(userFilePath, formattedDate + " " + Information.score + "\n", StandardOpenOption.APPEND);
         } catch (IOException e) {
             e.printStackTrace();
         }


         for (int i = 0; i < info.size(); i++) {
             String[] line = info.get(i).split(" ");
             System.out.println("Score is" + line[1]);
             System.out.println("Date is" + line[0]);
         }
     }
 }
