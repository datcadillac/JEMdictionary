package src.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

public class ResultController {

    @FXML public Label marks, markstext, correcttext, wrongtext, correctNum, wrongNum;
    @FXML private Button googleTranslate;
    @FXML private Button homeButton;
    @FXML private Button gameButton;
    

    int correct;
    int wrong;

    @FXML
    private void initialize() {
        correct = QuizController.correct;
        wrong = QuizController.wrong;

        correcttext.setText("Số câu đúng: " + correct);
        correctNum.setText(correct + "");
        wrongtext.setText("Số câu sai: " + String.valueOf(QuizController.wrong));
        wrongNum.setText(wrong + "");
        marks.setText(correct + "");
        markstext.setText(correct + " điểm");
        QuizController.correct = 0;
        QuizController.wrong = 0;
        QuizController.counter = 0;
    }

    public void setGoogleTranslateScene(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("JEMdictionary");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/src/ui/GoogleController.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/src/resource/styles/main.css");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHomeScene(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("JEMdictionary");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/src/ui/MainController.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/src/resource/styles/main.css");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGameScene(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("JEMdictionary");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/src/game/home.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/src/resource/styles/game.css");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void setPlayquizbtn(ActionEvent event) {
        try {
            if (QuestionManagement.getQuestionArrayList().isEmpty()) {
                QuestionManagement.importQuestion();
            }
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("quiz.fxml"));
            Parent root = fxml.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
