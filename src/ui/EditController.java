package src.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import src.main.DictionaryManagement;

public class EditController {

    @FXML public TextField editTarget;
    @FXML public TextField editExplain;
    @FXML public Button saveButton;
    @FXML public Button cancelButton;

    @FXML
    private void setSaveButton(ActionEvent event) {
        try {
            String target = editTarget.getText();
            String explain = editExplain.getText();
            if (!DictionaryManagement.alreadyIn(target)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setContentText("Từ " + target + " không có trong bộ dữ liệu.");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setContentText("Chỉnh sửa từ " + target + " thành công!");
                DictionaryManagement.editWord(target, explain);
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

    @FXML
    public void getEditExplain(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            editExplain.setText(DictionaryManagement.lookUpWord(editTarget.getText()));
        }
    }

}
