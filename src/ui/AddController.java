package src.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.main.DictionaryManagement;

public class AddController {

    @FXML public TextField addTarget;
    @FXML public TextField addExplain;
    @FXML public Button saveButton;
    @FXML public Button cancelButton;

    @FXML
    private void setSaveButton(ActionEvent event) {
        try {
            String target = addTarget.getText();
            String explain = addExplain.getText();
            if (DictionaryManagement.alreadyIn(target)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setContentText("Từ " + target + " đã có trong bộ dữ liệu.");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setContentText("Thêm từ " + target + " thành công!");
                DictionaryManagement.addWord(target, explain);
                DictionaryManagement.sorting();
                alert.show();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void setCancelButton(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
