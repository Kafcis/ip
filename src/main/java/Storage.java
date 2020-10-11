import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    private static ArrayList<Task> taskList = new ArrayList<Task>();
    private static String filepath = "savedata.txt";
    private static TaskList original = new TaskList(taskList);

    public Storage(String filePath) throws IOException {
        DataGetSet.setFilepath(filePath);

        try {
            taskList = DataGetSet.loadData(taskList, original);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Task> loadData() {
        if (taskList.size() == 0) {
            Ui.loading();
            try {
                taskList = DataGetSet.loadData(taskList, original);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return taskList;
    }

    public static void saveData(ArrayList<Task> taskList) {
        DataGetSet.saveData(taskList);
    }
}
