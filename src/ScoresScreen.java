import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScoresScreen {
    @FXML
    private ListView scoresList;

    private List<Integer> scores;

    public void initialize () throws IOException {
        Path userFilePath = Paths.get("src/userData/" + Information.username + ".txt");
        List<String> data = Files.readAllLines(userFilePath);

        scores = new ArrayList<>();

        for (int i = 0; i <     data.size(); i++) {
            String line = data.get(i);
            String[] splitLine = line.split(" ");
            if (splitLine.length > 1) {
                int score = Integer.parseInt(splitLine[1]);
                scores.add(score);
            }
        }

        Collections.sort(scores, Collections.reverseOrder());

        for (int i = 0; i < 5; i++) {
            int score = scores.get(i);
            scoresList.getItems().add(score);
        }
    }

    public void top5scores() {


    }
}
