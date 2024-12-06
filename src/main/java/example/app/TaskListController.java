package example.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;

public class TaskListController {
    @FXML
    private ListView<String> taskListView;

    @FXML
    void initialize() {
        // Bind tasks to the ListView
        taskListView.setItems(TaskManager.getTasks());
    }

    @FXML
    private void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TaskScreen.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) taskListView.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
