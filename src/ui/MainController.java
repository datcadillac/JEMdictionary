package src.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


import javafx.stage.Stage;
import src.main.DictionaryCommandLine;
import src.main.DictionaryManagement;
import src.main.TextToSpeech;
import src.main.Word;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML private TextField searchField;
    @FXML private ListView searchView;
    @FXML private WebView mainView = new WebView();
    @FXML private WebEngine mainEngine;
    @FXML private Button addButton;
    @FXML private Button editButton;
    @FXML private Button delButton;
    @FXML private Button importButton;
    @FXML private Button exportButton;
    @FXML private Button pronButton;
    @FXML private Button googleTranslate;
    @FXML private Button homeButton;
    @FXML private Button gameButton;


    @FXML
    public void updateSearchView() {
        searchView.getItems().clear();
        String searchText = searchField.getText();
        ArrayList<Word> searchTarget = DictionaryManagement.searchWord(searchText);
        for (Word word : searchTarget) {
            searchView.getItems().add(word.getWord_target());
        }
    }

    @FXML
    public void changeFocusDown(KeyEvent event) {
        if (event.getCode() == KeyCode.DOWN) {
            searchView.requestFocus();
            if (!searchView.getItems().isEmpty()) {
                searchView.getSelectionModel().select(0);
            }
        }
    }

    public void selectWord(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            String target = (String) searchView.getSelectionModel().getSelectedItem();
            System.out.println(target);
            mainEngine.loadContent(DictionaryManagement.lookUpWord(target), "text/html");
            pronButton.setVisible(true);
//            TextToSpeech.speak(target);
        }
    }

    public void clickWord(MouseEvent mouseEvent) {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
            if(mouseEvent.getClickCount() == 2){
                String target = (String) searchView.getSelectionModel().getSelectedItem();
                System.out.println(target);
                mainEngine.loadContent(DictionaryManagement.lookUpWord(target), "text/html");
                pronButton.setVisible(true);
//            TextToSpeech.speak(target);
            }
        }
    }

    @FXML
    public void importFromFile() {
        DictionaryManagement.insertFromFile();
        updateSearchView();
    }

    @FXML
    public void addWord(ActionEvent event) {
        try {
            Stage addStage = new Stage();
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            addStage.initOwner(appStage);
            addStage.setTitle("Thêm từ");
            addStage.setOnHidden(event1 -> updateSearchView());
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("AddController.fxml"));
            Parent root = fxml.load();
            Scene scene = new Scene(root);
            addStage.setScene(scene);
            addStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void editWord(ActionEvent event) {
        try {
            Stage addStage = new Stage();
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            addStage.initOwner(appStage);
            addStage.setTitle("Chỉnh sửa từ");
            addStage.setOnHidden(event1 -> updateSearchView());
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("EditController.fxml"));
            Parent root = fxml.load();
            Scene scene = new Scene(root);
            addStage.setScene(scene);
            addStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteWord() {
        try {
            String selectingWord = (String) searchView.getSelectionModel().getSelectedItem();
            if (selectingWord == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setContentText("Chưa có từ nào được chọn.");
                alert.show();
                return;
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Xác nhận xoá");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                DictionaryManagement.deleteWord(selectingWord);
                updateSearchView();
                updateMainView();
            } else {
                System.out.println("Huỷ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMainView() {
        String selectingWord = (String) searchView.getSelectionModel().getSelectedItem();
        if (selectingWord == null) {
            mainEngine.loadContent("", "text/html");
            pronButton.setVisible(false);
        }
    }

    public void setExportButton() {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Xác nhận xuát dữ liệu ra file");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                DictionaryManagement.dictionaryExportToFile();
            } else {
                System.out.println("Huỷ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPronButton() {
        try {
            String selectingWord = (String) searchView.getSelectionModel().getSelectedItem();
            if (selectingWord == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setContentText("Chưa có từ nào được chọn.");
                alert.show();
                return;
            }
            TextToSpeech.speak(selectingWord);
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
            scene.getStylesheets().add("/src/resource/styles/google.css");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainEngine = Objects.requireNonNull(mainView.getEngine());
    }
}
