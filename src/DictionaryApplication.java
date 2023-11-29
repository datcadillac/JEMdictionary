package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import src.main.Dictionary;
import src.main.DictionaryCommandLine;
import src.main.DictionaryManagement;
import src.ui.MainController;

import java.util.Objects;

public class DictionaryApplication extends Application {

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement.addWord(" ", " ");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("JEMdictionary");
            FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("ui/MainController.fxml")));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/src/resource/styles/main.css");
            primaryStage.getIcons().add(new Image("/src/resource/media/normal/mainIcon.png"));
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
