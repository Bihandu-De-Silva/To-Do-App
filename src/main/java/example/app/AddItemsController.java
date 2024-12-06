package example.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AddItemsController {
    @FXML
    private AnchorPane AddTaskScreen;

    @FXML
    private Button addButton;

    @FXML
    void initialize() {
        addButton.setOnAction(this::handleAddButtonClick);
    }

    private void handleAddButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TaskScreen.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) AddTaskScreen.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
