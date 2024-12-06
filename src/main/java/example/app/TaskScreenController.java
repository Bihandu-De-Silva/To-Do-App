package example.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TaskScreenController {

    @FXML
    private Button SaveButton;

    @FXML
    private AnchorPane TaskScreen;

    @FXML
    private TextField taskField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea descriptionArea;

    @FXML
    void initialize() {
        SaveButton.setOnAction(this::handleSaveTask);
    }

    private void handleSaveTask(ActionEvent event) {
        String taskName = taskField.getText();
        String taskDate = datePicker.getValue() != null ? datePicker.getValue().toString() : "No date set";
        String taskDescription = descriptionArea.getText();

        // Validate input
        if (taskName == null || taskName.trim().isEmpty()) {
            System.out.println("Task name is required!");
            return;
        }

        // Save the task to the shared model
        String taskDetails = "Task: " + taskName + ", Date: " + taskDate + ", Description: " + taskDescription;
        TaskManager.addTask(taskDetails);

        // Clear fields after saving
        taskField.clear();
        datePicker.setValue(null);
        descriptionArea.clear();
        System.out.println("Task saved: " + taskDetails);
        navigateToTaskList();
    }

    private void navigateToTaskList() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TaskListScreen.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) TaskScreen.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

