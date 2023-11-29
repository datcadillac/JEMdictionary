package src.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class QuizController {

    @FXML private Label question;
    @FXML private Button googleTranslate;
    @FXML private Button homeButton;
    @FXML private Button gameButton;

    @FXML
    private Button opt1, opt2, opt3, opt4;


    public static ArrayList<Question> questionArrayList = QuestionManagement.getQuestionArrayList();
    public static int counter = 0;
    public static int correct = 0;
    public static int wrong = 0;
    public static int num;

    @FXML
    private void initialize() {
        loadQuestions();
    }

    private void loadQuestions() {
        Random random = new Random();
        num = random.nextInt((questionArrayList.size()));
        question.setText((counter + 1) + ". " + questionArrayList.get(num).getQuestion());
        opt1.setText(questionArrayList.get(num).getOpt1());
        opt2.setText(questionArrayList.get(num).getOpt2());
        opt3.setText(questionArrayList.get(num).getOpt3());
        opt4.setText(questionArrayList.get(num).getOpt4());
    }


    @FXML
    public void opt1clicked(ActionEvent event) {
        if (questionArrayList.get(num).checkAnswer(opt1.getText())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 9) {
            try {
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                Stage quizstage = new Stage();
                quizstage.setTitle("JEMdictionary");
                quizstage.setScene(quizscene);
                quizstage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }

    }

    @FXML
    public void opt2clicked(ActionEvent event) {
        if (questionArrayList.get(num).checkAnswer(opt2.getText())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 9) {
            try {
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                Stage quizstage = new Stage();
                quizstage.setTitle("JEMdictionary");
                quizstage.setScene(quizscene);
                quizstage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }

    @FXML
    public void opt3clicked(ActionEvent event) {
        if (questionArrayList.get(num).checkAnswer(opt3.getText())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 9) {
            try {
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                Stage quizstage = new Stage();
                quizstage.setTitle("JEMdictionary");
                quizstage.setScene(quizscene);
                quizstage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }

    @FXML
    public void opt4clicked(ActionEvent event) {
        if (questionArrayList.get(num).checkAnswer(opt4.getText())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 9) {
            try {
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                Stage quizstage = new Stage();
                quizstage.setTitle("JEMdictionary");
                quizstage.setScene(quizscene);
                quizstage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
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

}

