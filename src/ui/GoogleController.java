package src.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import src.main.TextToSpeech;
import src.main.TranslateAPI;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GoogleController implements Initializable {

    @FXML private WebView webView;
    @FXML private TextArea textArea;
    @FXML private WebEngine webEngine;
    @FXML private Button homeButton;
    @FXML private Button googleTranslate;
    @FXML private Button pronButton;
    @FXML private Button switchButton;
    @FXML private Button gameButton;
    public static String langFrom = "en";
    public static String langTo = "vi";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webEngine = webView.getEngine();
    }

    public void updateView(KeyEvent keyEvent) {
        try {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                String target = textArea.getText();
                webEngine.loadContent(TranslateAPI.googleTranslate(langFrom, langTo, target), "text/html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGoogleTranslateScene(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("JEMdictionary");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GoogleController.fxml"));
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainController.fxml"));
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

    public void switchLang() {
        String temp = langTo;
        langTo = langFrom;
        langFrom = temp;
        switchButton.setText(langFrom + " -> " + langTo);
        System.out.println(langFrom + " - " + langTo);
    }

    public void setPronButton() {
        TextToSpeech.speak(textArea.getText());
    }

}
