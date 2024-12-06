package example.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskManager {
    private static final ObservableList<String> tasks = FXCollections.observableArrayList();

    public static ObservableList<String> getTasks() {
        return tasks;
    }

    public static void addTask(String task) {
        tasks.add(task);
    }
}
