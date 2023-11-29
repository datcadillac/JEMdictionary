package src.game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class HomeController {
    @FXML private Button playquizbtn;
    @FXML private Button googleTranslate;
    @FXML private Button homeButton;
    @FXML private Button gameButton;

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